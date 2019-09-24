#include <stdio.h>

int power(int m, int n);
void lala();
void testarray(int numbers[]);

/* test power function */
int main()
{
	int i;

	for (i = 0; i < 10; ++i)
		printf("%d %d %d\n", i, power(2,i), power(-3,i));
	
	lala();

	int testary[2];
	for (i = 0; i < 2; ++i)
		testary[i] = 0;

	testarray(testary);

	printf("%d\n", testary[0]);

	return 0;
}

/* see if arrays pass by value or not */
void testarray(int numbers[])
{
	++numbers[0];
	return;
}

/* power: raise base to n-th power; n >= 0 */
//int power(int base, int n)
//{
//	int i, p;
//
//	p = 1;
//	for (i = 1; i <= n; ++i)
//		p = p * base;
//	return p;
//}

/* a version of power that makes more use of how C
   functions are passed "by value" rather than
                               "by reference" */
int power(int base, int n)
{
	int p;

	for (p = 1; n > 0; --n)
		p = p * base;
	return p;
}

void lala()
{
	printf("lala\n");
}
