#include <stdio.h>

int compare(int (*comp)(int, int), int i, int j);

int main(void)
{
	int lessthan(int i, int j);

	printf("%d\n", compare(lessthan, 5, 2));

	return 0;
}

int lessthan(int i, int j)
{
	return i < j;
}

int compare(int (*comp)(int, int), int i, int j)
{
	return (*comp)(i, j);
}
