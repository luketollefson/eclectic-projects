#include <stdio.h>

int main()
{
	int i = 2147483647;
	printf("%d\n", (i > 0) ? i % 10 : -(i % 10));
	return 0;
}
