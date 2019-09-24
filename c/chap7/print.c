#include <stdio.h>

/* cat: concatenate files, version 1 */
int main(int argc, char *argv[])
{
	FILE *fp;
	int page;
	void filecopy(FILE *, FILE *);

	page = 1;
	if (argc == 1)	/* no args; copy stardard input */
		filecopy(stdin, stdout);
	else
		while (--argc > 0)
			if ((fp = fopen(*++argv, "r")) == NULL) {
				printf("cat: can't open %s\n", *argv);
				return 1;
			} else {
				printf("%s%-16s %d\n", (page == 1) ? "" : "\n", *argv, page);
				filecopy(fp, stdout);
				fclose(fp);
				page++;
			}
	return 0;
}

/* filecopy: copy file ifp to file ofp */
void filecopy(FILE *ifp, FILE *ofp)
{
	int c;

	while ((c = getc(ifp)) != EOF)
		putc(c, ofp);
}
