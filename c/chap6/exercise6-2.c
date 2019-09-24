#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define MAXWORD	100
#define IDLEN	6

struct tnode {		/* the tree node: */
	char *word;		/* points to the text */
	int count;		/* number of occurrences */
	int print;		/* non-zero to print */
	struct tnode *left;	/* left child */
	struct tnode *right;	/* right child */
};

struct tnode *addtree(struct tnode *, char *, int, int);
void treeprint(struct tnode *);
int getword(char *, int);

/* word frequency count */
int main(int argc, char *argv[])
{
	int idlen;
	if (argc >= 2)
		idlen = atoi(*++argv);
	else
		idlen = IDLEN;
	struct tnode *root;
	char word[MAXWORD];

	root = NULL;
	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			root = addtree(root, word, idlen, 0);
	treeprint(root);
	return 0;
}

struct tnode *talloc(void);

/* addtree: add a node with w, at or below p */
struct tnode *addtree(struct tnode *p, char *w, int idlen, int print)
{
	int cond;

	if (p == NULL) {
		p = talloc();
		p->word = strdup(w);
		p->print = print;
		p->count = 1;
		p->left = p->right = NULL;
	} else if ((cond = strcmp(w, p->word)) == 0)
		p->count++;	/* repeated word */
	else if (cond < 0) {	/* less than into left subtree */
		p->print |= (!strncmp(p->word, w, idlen));
		print |= (!strncmp(p->word, w, idlen));
		p->left = addtree(p->left, w, idlen, print);
	} else {	/* greater than into right subtree */
		p->print |= (!strncmp(p->word, w, idlen));
		print |= (!strncmp(p->word, w, idlen));
		p->right = addtree(p->right, w, idlen, print);
	}
	return p;
}

/* treeprint: in-order print of tree p */
void treeprint(struct tnode *p)
{
	if (p != NULL) {
		treeprint(p->left);
		if (p->print)
			printf("%4d %s\n", p->count, p->word);
		treeprint(p->right);
	}
}

/* talloc: make a tnode */
struct tnode *talloc(void)
{
	return (struct tnode *) malloc(sizeof(struct tnode));
}

#include "getch.c"

/* getword: get next word or character from input */
/*
int getword(char *word, int lim)
{
	int c, getch(void);
	void ungetch(int);
	char *w = word;

	while (isspace(c = getch()))
		;
	if (c != EOF)
		*w++ = c;
	if (!isalpha(c)) {
		*w = '\0';
		return c;
	}
	for ( ; --lim > 0; w++)
		if (!isalnum(*w = getch())) {
			ungetch(*w);
			break;
		}
	*w = '\0';
	return word[0];
}
*/

/* getword: get next word or character from input */
int getword(char *word, int lim)
{
        int c, c2, c3, getch(void);
        void ungetch(int);
        char *w = word;

        /* skip whitespace */
        while (isspace(c = getch()))
                ;

        /* skip string literals and character sequences */
        if (c == '\'' || c == '"') {
                if (c == '\'') {
                        while ((c = getch()) != '\'')
                                if (c == '\\')
                                        getch();
                } else if (c == '"') {
                        while ((c = getch()) != '"')
                                if (c == '\\')
                                        getch();
                }
        }

        /* skip comments */
        if ((c2 = getch()) == '*' && c == '/')
                while ((c2 = getch()) != '/' && (c = c3) != '*')
                        c3 = c2;
        else
                ungetch(c2);

        /* skip preprocessor control lines */
        if (c == '#') {
                line_start:
                while ((c = getch()) != '\n')
                        ;
                if ((c = getch()) == '#')
                        goto line_start;
        }

        if (c != EOF)
                *w++ = c;
        if (!isalpha(c) || c == '_') {
                *w = '\0';
                return c;
        }
        for ( ; --lim > 0; w++)
                if (!isalnum(*w = getch())) {
                        ungetch(*w);
                        break;
                }
        *w = '\0';
        return word[0];
}
