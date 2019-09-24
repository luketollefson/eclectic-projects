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

/* word frequency count */
int main(void)
{
	struct tnode *root;
	struct mtnode *mnode;
	char word[MAXWORD];

	root = NULL;
	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			root = addtree(root, word);
	treeprint(root);
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

int qnoise(char *word);

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
