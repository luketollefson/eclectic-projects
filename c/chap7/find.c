#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAXLINE	1000

int main(int argc, char *argv[])
{
	FILE *fp;
	char *prog = argv[0];	/* program name for errors */
	char line[MAXLINE];
	char *pattern = *++argv;
	int exiterr = 0;

	if (argc < 3) {
		fprintf(stderr, "%s: usage, %s (pattern) (file1) [file2...]\n", prog, prog);
		exit(1);
	}
	argc--;
	while (--argc > 0) {
		fp = fopen(*++argv, "r");
		if (fp == NULL) {
			fprintf(stderr, "%s: can't open %s\n", prog, *argv);	
			exiterr = 2;
			continue;
		} else {
			while (fgets(line, MAXLINE, fp) != NULL) {
				if (strstr(line, pattern) != NULL) {
					printf("%-8s %s", *argv, line);
				}
			}
		}
		fclose(fp);
	}
	exit(exiterr);
}
