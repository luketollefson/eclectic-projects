#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int n = atoi(*++argv);

	int v[n];

	printf("%d\n", sizeof v);
	int *vp = v;

	return 0;
}
