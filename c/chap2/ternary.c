#include <stdio.h>

char lower(char c);

int main()
{
	/* example use of ternary operator
	 * expr1 ? expr2 : expr3
	 * if expr1 is true than expr2, else expr3
	 * Example:
	 * z = (a > b) ? a : b; 
	 */

	/*
	char a[] = "hello world!";

	int n = 5;
	for (int i = 0; i < n; i++)
		printf("%c%c", a[i], (i%10==9 || i==n-1) ? '\n' : ' ');
	*/

	printf("%d %d\n", 'G', 'g');
	printf("%c\n", lower('G'));

	int n = 1;
	printf("You have %d item%s.\n", n, n==1 ? "" : "s");
}

char lower(char c)
{
	return ('A' <= c <= 'Z') ? c - 'A' + 'a' : c;
}
