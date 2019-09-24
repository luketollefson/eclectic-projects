#include <stdio.h>
#include <stdlib.h>

#define DEFAULT	10

int main(int argc, int *argv[])
{
	nlines = (argc > 1) ? atoi(*++argv) : DEFAULT;

	char *lineptr[nlines];

	int startp = readlines(lineptr, nlines);
}

/* readlines: read input lines */
int readlines(char *lineptr[], int maxlines)
{
	
