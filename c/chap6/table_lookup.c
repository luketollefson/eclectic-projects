#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct nlist {
	struct nlist *next;
	char *name;
	char *defn;
};

#define HASHSIZE 1

unsigned hash(char *s);
struct nlist *lookup(char *s);
struct nlist *install(char *name, char *defn);
void undef(char *name);

int main(void)
{
	printf("%u\n", hash("Hello"));
	install("aaaaa", "11111");
	install("bbbbb", "22222");
	install("ccccc", "33333");
	install("ddddd", "44444");
	undef("bbbbb");
	printf("%s\n", lookup("ddddd")->defn);
	if (lookup("bbbbb") != NULL)
		printf("%s\n", lookup("bbbbb")->name);
	else
		printf("bbbbb was deleted\n");

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

