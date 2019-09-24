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
int binsearch(char *, struct key *, int);

/* count C keywords */
int main(void)
{
	int n;
	char word[MAXWORD];

	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			if ((n = binsearch(word, keytab, NKEYS)) >= 0)
				keytab[n].count++;
	for (n = 0; n < NKEYS; n++)
		if (keytab[n].count > 0)
			printf("%4d %s\n", keytab[n].count, keytab[n].word);
	return 0;
}

/* binsearch: find word in tab[0]...tab[n-1] */
int binsearch(char *word, struct key tab[], int n)
{
	int cond;
	int low, high, mid;

	low = 0;
	high = n - 1;
	while (low <= high) {
		mid = (low+high) / 2;
		if ((cond = strcmp(word, tab[mid].word)) < 0)
			high = mid - 1;
		else if (cond > 0)
			low = mid + 1;
		else
			return mid;
	}
	return -1;
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
