#include <stdio.h>
#include <string.h>
#include <strings.h>

#define MAXLINES 5000	/* max #lines to be sorted */
char *lineptr[MAXLINES];	/* pointers to text lines */

int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines);
void writelinesb(char *lineptr[], int nlines);

#include "qsort2.c"
void qsort2(void *lineptr[], int left, int right,
	   int (*comp)(void *, void*));

#include "numcmp.c"
int numcmp(const char *, const char *);
int dir_order(const char *s1, const char *s2);

int fold = 0;
/* sort input lines */
int main(int argc, char *argv[])
{
	int nlines;		/* number of input lines read */
	int c, numeric = 0, reverse = 0, dir = 0;

	while (--argc > 0 && (*++argv)[0] == '-')
		while (c = *++argv[0])
			switch (c) {
			case 'n':
				numeric = 1;
				break;
			case 'r':
				reverse = 1;
				break;
			case 'f':
				fold = 1;
				break;
			case 'd':
				dir = 1;
				break;
			default:
				printf("sort: illegal option %c\n", c);
				break;
			}

	if ((nlines = readlines(lineptr, MAXLINES)) >= 0) {
		qsort2((void **) lineptr, 0, nlines-1,
		      (int (*)(void*,void*))(numeric ? numcmp : (dir ? dir_order : (fold ? strcasecmp : strcmp))));
		if (reverse)
			writelinesb(lineptr, nlines);
		else
			writelines(lineptr, nlines);
		return 0;
	} else {
		printf("error: input too big to sort\n");
		return 1;
	}
}

#include <ctype.h>
int dir_order(const char *s1, const char *s2)
{
	int i;
	if (fold == 0) {
		for (i = 0; *s1 == *s2 || !(isalnum(*s1) || isblank(*s1)) || !(isalnum(*s2) || isblank(*s2)); s1++, s2++)
			if (*s1 == '\0')
				return 0;
			else if (!(isalnum(*s1) || isblank(*s1)) || !(isalnum(*s2) || isblank(*s2)))
				continue;
		return *s1 - *s2;
	} else {
		for (i = 0; tolower(*s1) == tolower(*s2) || !(isalnum(*s1) || isblank(*s1)) || !(isalnum(*s2) || isblank(*s2)); s1++, s2++)
			if (*s1 == '\0')
				return 0;
			else if (!(isalnum(*s1) || isblank(*s1)) || !(isalnum(*s2) || isblank(*s2)))
				continue;
		return tolower(*s1) - tolower(*s2);
	}
}

#include "getline2.c"
#include "alloc.c"
#define MAXLEN 100000 /* max length of any input line */
int getline2(char *, int);
char *alloc(int);

/* readlines: read input lines */
int readlines(char *lineptr[], int maxlines)
{
	int len, nlines;
	char *p, line[MAXLEN];

	nlines = 0;
	while ((len = getline2(line, MAXLEN)) > 0)
		if (nlines >= maxlines || (p = alloc(len)) == NULL)
			return -1;
		else {
			line[len-1] = '\0'; /* delete newline */
			strcpy(p, line);
			lineptr[nlines++] = p;
		}
	return nlines;
}

/* writelines: write output lines */
void writelines(char *lineptr[], int nlines)
{
	while (nlines-- > 0)
		printf("%s\n", *lineptr++);
}

/* writelinesb: write output lines backward */
void writelinesb(char *lineptr[], int nlines)
{
	lineptr += nlines-1;
	int i = 0;
	while (i < nlines) {
		printf("%s\n", *lineptr--);
		i++;
	}
}
