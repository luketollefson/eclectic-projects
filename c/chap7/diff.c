#include <stdio.h>
#include <stdlib.h>

#define MAXLINE	1000

int main(int argc, char *argv[])
{
	char s1[MAXLINE], s2[MAXLINE], *s1p, *s2p;
	FILE *fp1, *fp2;
	char *prog = argv[0];

	if (argc >= 3) {
		if ((fp1 = fopen(*++argv, "r")) == NULL)
			fprintf(stderr, "%s: can't open %s\n", prog, *argv);
		if ((fp2 = fopen(*++argv, "r")) == NULL)
			fprintf(stderr, "%s: can't open %s\n", prog, *argv);
		if (fp1 == NULL || fp2 == NULL)
			exit(2);
	} else {
		fprintf(stderr, "usage: %s (file1) (file2)\n", prog);
		exit(1);
	}

	while (fgets(s1, MAXLINE, fp1) && fgets(s2, MAXLINE, fp2))
		for (s1p = s1, s2p = s2; *s1p && *s2p; s1p++, s2p++)
			if (*s1p != *s2p) {
				printf("%s", s1);
				printf("%s", s2);
				return 0;
			}
	if (ferror(stdout)) {
		fprintf(stderr, "%s: error writitng stdout\n", prog);
		exit(3);
	}
	return 0;
}
