#include <stdio.h>
#include <string.h>

#define MAXLINES 500000	/* max #lines to be sorted */

char *lineptr[MAXLINES];	/* pointers to text lines */

int readlines(char *lineptr[], char *lines, int nlines);
void writelines(char *lineptr[], int nlines);

#include "qsort.c"
void qsort(char *lineptr[], int left, int right);

/* sort input lines */
int main(void)
{
	int nlines;	/* number of input lines read */
	char lines[5000000]; /* storage for the lines */

	if ((nlines = readlines(lineptr, lines, MAXLINES)) >= 0) {
		qsort(lineptr, 0, nlines-1);
		writelines(lineptr, nlines);
		return 0;
	} else {
		printf("error: input too big to sort\n");
		return 1;
	}
}

#include "getline2.c"
#define MAXLEN 1000	/* max length of a line */
int getline2(char *, int);

/* readlines: read input lines */
int readlines(char *lineptr[], char *lines, int maxlines)
{
	int len, nlines;

	nlines = 0;
	while ((len = getline2(lines, MAXLEN)) > 0)
		if (nlines >= maxlines)
			return -1;
		else {
			lines+=len;
			*(lines-1) = '\0'; /* delete newlines */
			lineptr[nlines++] = lines;
		}
	return nlines;
}

/* writelines: write output lines */
void writelines(char *lineptr[], int nlines)
{
	while (nlines-- > 0)
		printf("%s\n", *lineptr++);
}
