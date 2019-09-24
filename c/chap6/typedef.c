#include <stdlib.h>

typedef struct tnode *Treeptr;

/* PFI: pointer to a function of two char * args returning int */
/* use PFI strcmp, numcmp; */
typedef int (*PFI)(char *, char *);

typedef struct tnode {	/* the tree node: */
	char *word;	/* points to the text */
	int count;	/* number of occurrences */
	Treeptr left;	/* left child */
	Treeptr right;	/* right child */
} Treenode;

Treeptr talloc(void)
{
	return (Treeptr) malloc(sizeof(Treenode));
}
