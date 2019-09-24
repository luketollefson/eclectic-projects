#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAXWORD	100
#define MAXLINES 1000

struct tnode {		/* the tree node: */
	char *word;		/* points to the text */
	int count;		/* number of occurrences */
	int lines[MAXLINES];
	int *l;
	struct tnode *left;	/* left child */
	struct tnode *right;	/* right child */
};

struct mtnode {		/* meta-tree node: */
	struct tnode *node;	/* root node */
	struct mtnode *left;	/* node with lower count */
	struct mtnode *right;	/* node with higher cound */
};

char *noise_words[] = {
	"a"
	"and",
	"be",
	"of",
	"that",
	"the",
	"to"
};
#define NNWORDS	(sizeof noise_words / sizeof *noise_words)

struct tnode *addtree(struct tnode *, char *);
void treeprint(struct tnode *);
int getword(char *, int);
int line = 1;
void mtreeprint(struct mtnode *p);
struct mtnode *maddtree(struct mtnode *p, struct tnode *t);

/* word frequency count */
int main(void)
{
	struct tnode *root;
	struct mtnode *mroot;
	char word[MAXWORD];

	root = NULL;
	mroot = NULL;
	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			root = addtree(root, word);
	mroot = maddtree(mroot, root);
	mtreeprint(mroot);
	/*treeprint(root);*/
	return 0;
}

struct tnode *talloc(void);

/* addtree: add a node with w, at or below p */
struct tnode *addtree(struct tnode *p, char *w)
{
	int cond;

	if (p == NULL) {
		p = talloc();
		p->word = strdup(w);
		p->count = 1;
		p->l = p->lines;
		*p->l++ = line;
		p-> left = p->right = NULL;
	} else if ((cond = strcmp(w, p->word)) == 0) {
		p->count++;	/* repeated word */
		*p->l++ = line;
	} else if (cond < 0)	/* less than into left subtree */
		p->left = addtree(p->left, w);
	else		/* greater than into right subtree */
		p->right = addtree(p->right, w);
	return p;
}

struct mtnode *maddnode(struct mtnode *p, struct tnode *t);

/* maddtree: add a node in the correct spot */
struct mtnode *maddtree(struct mtnode *p, struct tnode *t)
{
	if (t->left)
		p = maddtree(p, t->left);
	p = maddnode(p, t);
	if (t->right)
		p = maddtree(p, t->right);
	return p;
}

struct mtnode *mtalloc(void);
/* maddnode: add one mtnode */
struct mtnode *maddnode(struct mtnode *p, struct tnode *t)
{
	int cond;
	if (p == NULL) {
		p = mtalloc();
		p->node = t;
	} else if (t->count <= p->node->count) {
		/* larger elements belong on the left */
		p->right = maddnode(p->right, t);
	} else {
		p->left = maddnode(p->left, t);
	}
	return p;
}

int qnoise(char *word);

/* mtreeprint: print the meta tree, which is sorted according to wcount */
void mtreeprint(struct mtnode *p)
{
	if (p != NULL) {
		mtreeprint(p->left);
		if (p->node->word) {
			printf("%4d %s:", p->node->count, p->node->word);
			for (int *ln = p->node->lines; ln < p->node->l; ln++)
				printf(" %d%c", *ln, (ln+1 < p->node->l) ? ',' : '\n'); 
		}
		mtreeprint(p->right);
	}
}

/* treeprint: in-order print of tree p */
void treeprint(struct tnode *p)
{
	if (p != NULL) {
		treeprint(p->left);
		if (qnoise(p->word)) {
			printf("%4d %s:", p->count, p->word);
			for (int *ln = p->lines; ln < p->l; ln++)
				printf(" %d%c", *ln, (ln+1 < p->l) ? ',' : '\n'); 
		}
		treeprint(p->right);
	}
}

#include <stdlib.h>
/* talloc: make a tnode */
struct tnode *talloc(void)
{
	return (struct tnode *) malloc(sizeof(struct tnode));
}

/* mtalloc: make a mtnode */
struct mtnode *mtalloc(void)
{
	return (struct mtnode *) malloc(sizeof(struct mtnode));
}

/* qnoise: return zero if noise word */
int qnoise(char *word)
{
	int cond;
	int low, high, mid;

	low = 0;
	high = NNWORDS - 1;
	while (low <= high) {
		mid = (low+high) / 2;
		if ((cond = strcmp(word, noise_words[mid])) < 0)
			high = mid - 1;
		else if (cond > 0)
			low = mid + 1;
		else
			return 0;
	}
	return 1;
}

#include "getch.c"

/* getword: get next word or character from input */
int getword(char *word, int lim)
{
	int c, getch(void);
	void ungetch(int);
	char *w = word;

	while (isspace(c = getch()))
		if (c == '\n')
			line++;
	if (c != EOF)
		*w++ = tolower(c);
	if (!isalpha(c)) {
		*w = '\0';
		return c;
	}
	for ( ; --lim > 0; w++)
		if (!isalnum(*w = tolower(getch()))) {
			ungetch(*w);
			break;
		}
	*w = '\0';
	return word[0];
}
