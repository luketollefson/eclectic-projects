#include <stdio.h>

void testfunc(int a);

int main()
{
	putchar('\0');
	putchar('\0');
	putchar('\0');
	putchar('\0');
	printf("%d", '\0');
	/*
	if ('\"' == '"')
		printf("true\n");
	else
		printf("false\n");
	
	printf("([{\"'''");
	putchar('(');
	*/

	/*
	testfunc(0);
	testfunc(0);
	testfunc(3);
	testfunc(0);
	testfunc(0);
	testfunc(0);
	testfunc(0);
	testfunc(0);
	*/

	return 0;
}

/* testfunc: testing garbage collection, there is none */
void testfunc(int a)
{
	int i;
	printf("%d\n", ++i);
	if (a != 0)
		i = a;
}
