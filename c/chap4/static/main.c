#include <stdio.h>

int number(void);

int main(void)
{
	for (int i = 0; i < 100000; i++)
		printf("%d\n", number());

	return 0;
}

int number(void)
{
	static int j = 0;
	return ++j;
}
