#include <stdio.h>

#define a printf("a\n")
#define b printf("b\n");
#define max(A, B) ((A) > (B) ? (A) : (B))
#define swap(t, x, y) t z = x; x = y; y = z

int main(void)
{
	/*
	b b b b
	a;
	a;
	*/
	int i = 5;
	int j = 4;
	swap(int, i, j);
	printf("%d\n", i);

	printf("%d\n", max(5, 4));

	return 0;
}
