#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

struct nlist {
	struct nlist *next;
	char *name;
	char *defn;
};

#define HASHSIZE 101
#define MAXWORD	100

unsigned hash(char *s);
struct nlist *lookup(char *s);
struct nlist *install(char *name, char *defn);
void undef(char *name);
int getword(char *word, int lim);

int main(void)
{
	char word[MAXWORD];
	char worddefn[MAXWORD];

	while (getword(word, MAXWORD) != EOF)
		if (strcmp(word, "define") == 0) {
			printf("%s", word);
			getword(word, MAXWORD);
			printf("%s", word);
			getword(worddefn, MAXWORD);
			printf("%s", worddefn);
			install(word, worddefn);
		} else if (lookup(word))
			printf("%s", lookup(word)->defn);
		else
			printf("%s", word);
}
	

static struct nlist *hashtab[HASHSIZE];	/* pointer table */

/* hash: from hash value for string s */
unsigned hash(char *s)
{
	unsigned hashval;

	for (hashval = 0; *s != '\0'; s++)
		hashval = *s + 31 * hashval;
	return hashval % HASHSIZE;
}

/* lookup: look for s in hashtab */
struct nlist *lookup(char *s)
{
	struct nlist *np;

	for (np = hashtab[hash(s)]; np != NULL; np = np->next)
		if (strcmp(s, np->name) == 0)
			return np;	/* found */
	return NULL;			/* not found */
}


/* install: put (name, defn) in hashtab */
struct nlist *install(char *name, char *defn)
{
	struct nlist *np;
	unsigned hashval;

	if ((np = lookup(name)) == NULL) {	/* not found */
		np = (struct nlist *) malloc(sizeof(*np));
		if (np == NULL || (np->name = strdup(name)) == NULL)
			return NULL;
		hashval = hash(name);
		np->next = hashtab[hashval];
		hashtab[hashval] = np;
	} else		/* already there */
		free((void *) np->defn);	/* free previous defn */
	if ((np->defn = strdup(defn)) == NULL)
		return NULL;
	return np;
}

/* undef: remove name from the table */
void undef(char *name)
{
	struct nlist *np;
	np = hashtab[hash(name)];
	if (strcmp(name, np->name) == 0) {
		if (np->next != NULL)
			hashtab[hash(name)] = np->next;
		hashtab[hash(name)] = NULL;
		free((void *) hashtab[hash(name)]);
		return;
	}

	for (np; np->next != NULL; np = np->next)
		if (strcmp(name, np->next->name) == 0) {
			np->next = np->next->next;
			free((void *) np->next);
			return;
		}
}

#include "getch.c"

/* getword: get next word or character from input */
/* spaces are printed */
int getword(char *word, int lim)
{
        int c, getch(void);
        void ungetch(int);
        char *w = word;

        while (isspace(c = getch()))
                printf("%c", c);
        if (c != EOF)
                *w++ = c;
        if (!isalpha(c) && !isdigit(c)) {
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
