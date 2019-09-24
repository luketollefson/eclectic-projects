#include <stdio.h>
#include <ctype.h>
#include <math.h>
#include "getch2.c"

#define SIZE	100

int main(void)
{
	int n, getfloat(float *);
	float array[SIZE];

	int ret_val;
	for (n = 0; n < SIZE && (ret_val = getfloat(&array[n])) != EOF; n++)
		if (ret_val == 0)
			n--;

	for (int i = 0; i < n; i++)
		printf("%g ", array[i]);

	printf("\n");

	return 0;
}

int getch2(void);
void ungetch2(int);

/* getfloat: get next float from input into *pn */
/* return EOF for end of file, positive value if */
/* a valid number, and zero for not a number */
int getfloat(float *pn)
{
	int c, sign;

	while (isspace(c = getch2()))	/* skip white space */
		;
	if (!isdigit(c) && c != EOF && c != '.' && c != '+' && c != '-')
		return 0;	/* not a number */

	sign = (c == '-') ? -1 : 1;	/* determine sign of float */
	if (c == '+' || c == '-')
		c = getch2();

	if (!isdigit(c) && c != '.' && c != EOF)
		return 0;


	for (*pn = 0; isdigit(c); c = getch2())	/* get before-decimal digits */
		*pn = 10 * *pn + (c - '0');

	int dec = 0;
	if (c == '.') {				/* get after-decimal digits */
		c = getch2();
		for (dec = 0; isdigit(c); c = getch2()) {
			*pn = 10 * *pn + (c - '0');
			dec++;
		}
	}

	int e = 0, e_sign = 0;			/* get sci-notation exponent */
	if (c == 'e' || c == 'E') {
		c = getch2();
		e_sign = (c == '-') ? -1 : 1;
		if (c == '+' || c == '-')
			c = getch2();
		for (e = 0; isdigit(c); c = getch2())
			e = 10 * e + (c - '0');
	}
			
	*pn = sign * ((*pn/pow(10, dec)) * (pow(10, e * e_sign)));
	if (c != EOF)
		ungetch2(c);
	return c;
}
