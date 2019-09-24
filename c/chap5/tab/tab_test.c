#include <stdio.h>
#include <stdlib.h>

#define MAXTABS 10

int main(int argc, char *argv[])
{
        int tabs[MAXTABS];

	argc--;
	for (int i = 0; i < MAXTABS; i++) {
		if (argc) {
			argv++;
			argc--;
		}
		tabs[i] = atoi(*argv);
	}

	for (int i = 0; i < MAXTABS; i++)
		printf("%d ", tabs[i]);
	printf("\n");
}
