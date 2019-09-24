#include <stdio.h>
#include <ctype.h>
//#include "getch.c"

#define SIZE	4

int main(void)
{
	int n, array[SIZE], getint(int *);

	int ret_val;
	for (n = 0; n < SIZE && (ret_val = getint(&array[n])) != EOF; n++)
		if (ret_val == 0)
			n--;

	for (int i = 0; i < n; i++)
		printf("%d ", array[i]);

	printf("\n");

	return 0;
}

int getch(void);
void ungetch(int);

/* getint: get next integer from input into *pn */
int getint(int *pn)
{
	int c, sign;

	while (isspace(c = getch()))	/* skip white space */
		;

	if (!isdigit(c) && c != EOF && c != '+' && c != '-') {
//		ungetch(c);	/* it's not a number */
		return 0;
	}

	sign = (c == '-') ? -1 : 1;
	if (c == '+' || c == '-')
		c = getch();

	if (isdigit(c))
		;
	else if (c == EOF)
		return c;
	else
		return 0;
		
	for (*pn = 0; isdigit(c); c = getch())
		*pn = 10 * *pn + (c - '0');
	*pn *= sign;
	if (c != EOF)
		ungetch(c);
	return c;
}
