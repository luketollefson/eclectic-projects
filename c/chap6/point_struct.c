struct key {
	char *word;
	int count;
} keytab[] = {
	"auto", 0,
	"break", 0,
	"case", 0,
	"char", 0,
	"const", 0,
	"continue", 0,
	"default", 0,
	/* ... */
	"unsigned", 0,
	"void", 0,
	"volatile", 0,
	"while", 0
};

#include <stdio.h>
#include <ctype.h>
#include <string.h>

//#define NKEYS	(sizeof keytab / sizeof(struct key))
#define NKEYS	(sizeof keytab / sizeof keytab[0])
#define MAXWORD 100

int getword(char *, int);
struct key *binsearch(char *, struct key *, int);

/* count C keywords; pointer version */
int main(void)
{
	char word[MAXWORD];
	struct key *p;

	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			if ((p=binsearch(word, keytab, NKEYS)) != NULL)
				p->count++;
	for (p = keytab; p < keytab + NKEYS; p++)
		if (p->count > 0)
			printf("%4d %s\n", p->count, p->word);
	return 0;
}

/* binsearch: find word in tab[0]...tab[n-1] */
struct key *binsearch(char *word, struct key *tab, int n)
{
	int cond;
	struct key *low = &tab[0];
	struct key *high = &tab[n];
	struct key *mid;

	while (low < high) {
		mid = low + (high-low) / 2;
		if ((cond = strcmp(word, mid->word)) < 0)
			high = mid;
		else if (cond > 0)
			low = mid + 1;
		else
			return mid;
	}
	return NULL;
}

#include "getch.c"

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
