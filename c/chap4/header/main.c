#include <stdio.h>
#include "test.h"
extern int i;

int main()
{
	i = 5;

	printf("%f", file2test());
	printf("%d", HELLO);
	printf("%d", i);
	return 0;
}
