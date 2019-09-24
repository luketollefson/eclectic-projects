#include <stdio.h>
#include <string.h>

#define MAXLINES 5000	/* max #lines to be sorted */
char *lineptr[MAXLINES];	/* pointers to text lines */

int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines);

#include "qsort2.c"
void qsort2(void *lineptr[], int left, int right,
	   int (*comp)(void *, void*));


/* sort input lines */
int main(int argc, char *argv[])
{
	int nlines;		/* number of input lines read */
	int c, numeric = 0, reverse = 0;	/* 1 if numeric sort */

	if ((nlines = readlines(lineptr, MAXLINES)) >= 0) {
		qsort2((void **) lineptr, 0, nlines-1,
		      (int (*)(void*,void*))(numeric ? numcmp : strcmp));
		return 0;
	} else {
		printf("error: input too big to sort\n");
		return 1;
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
