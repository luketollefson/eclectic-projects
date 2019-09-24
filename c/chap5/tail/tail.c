#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAXLINES 5000000	/* max #lines to be sorted */
#define DEFAULT	 10		/* default #lines tailed */

char *lineptr[MAXLINES];	/* pointers to text lines */

int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines, int tail);

/* sort input lines */
int main(int argc, char *argv[])
{
	int tail = (argc > 1) ? atoi(*++argv+1) : DEFAULT;
	int nlines;	/* number of input lines read */

	if ((nlines = readlines(lineptr, MAXLINES)) >= 0) {
		writelines(lineptr, nlines, tail);
		return 0;
	} else {
		printf("error: input too big to handel\n");
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
void writelines(char *lineptr[], int nlines, int tail)
{
	if (tail < nlines) {
		lineptr += nlines - tail;
		nlines = tail;
	}
	while (nlines-- > 0)
		printf("%s\n", *lineptr++);
}
