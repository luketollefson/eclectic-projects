#include <stdio.h>
#include <string.h>

void itob(int n, char s[], int base);
void reverse(char s[]);

int main()
{
	char s[100];
	int i = -1295;
	itob(i, s, 36);
	printf("%s\n", s);

	return 0;
}

/* itob: converts n into a base b string, e.g. a number into hex */
void itob(int n, char s[], int b)
{
	int i, sign;

	sign = (n >= 0) ? 1 : 0;

	i = 0;
	do {
		s[i] = (sign) ? n % b + '0' : -(n % b) + '0';
		if ((sign) ? n % b > 9 : -(n % b) > 9)
			s[i] += 7;
		i++;
	} while ((n /= b) != 0);
	if (!sign)
		s[i++] = '-';
	s[i] = '\0';
	reverse(s);
}

/* reverse: reverses string s */
void reverse(char s[])
{
	int c, i, j;

	for (i = 0, j = strlen(s)-1; i < j; i++, j--)
		c = s[i], s[i] = s[j], s[j] = c;	
}
