#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main(int argc, char *argv[])
{
	int c, csize;
	if (argc >= 2) {
		csize = ((strcmp(*++argv, "lower") == 0) ? 0 : 1);
	} else {
		printf("usage: ./a.out (case) < (file)\n");
		return 1;
	}

	while ((c = getchar()) != EOF)
		putchar((csize) ? toupper(c) : tolower(c));
	return 0;
}
