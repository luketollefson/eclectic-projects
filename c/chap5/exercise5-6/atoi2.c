#include <stdio.h>

int atoi2(char *s);

int main(void)
{
	printf("%d\n", atoi2(" -42"));

	return 0;
}

#include <ctype.h>

int atoi2(char *s)
{
	for ( ; isspace(*s); s++);

	int sign = 0;
	sign = (*s == '-') ? -1 : 1;
	if (*s == '-' || *s == '+')
		s++;

	int n = 0;
	for ( ; isdigit(*s); s++)
		n = 10 * n + (*s - '0');

	return sign * n;
}
