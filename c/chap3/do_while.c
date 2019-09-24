#include <stdio.h>
#include <string.h>

void itoa(int n, char s[], int width);
void reverse(char s[]);

int main()
{
	char s[100];
	itoa(-2, s, 4);
	printf("%s\n", s);

	return 0;
}

/* itoa: convert n to characters in s and gives it a min width of w */
void itoa(int n, char s[], int w)
{
	int i, sign;

	sign = 0;
	if (n < 0)	/* record sign */
		sign = -1;
	i = 0;
	do {		/* generate digits in reverse order */
		s[i++] = (n >= 0) ? n % 10 + '0' : -(n % 10) + '0';	/* get next digit */
	} while ((n /= 10) != 0);	/* delete it */
	if (sign < 0)
		s[i++] = '-';

	while (w - i > 0) 
		s[i++] = ' ';

	s[i] = '\0';
	reverse(s);
}

/* reverse: reverses s */
void reverse(char s[])
{
	int c, i, j;

	for(i = 0, j = strlen(s)-1; i <= j; i++, j--)
		c = s[i], s[i] = s[j], s[j] = c;
}
