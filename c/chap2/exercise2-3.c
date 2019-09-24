#include <stdio.h>
#include <ctype.h>

int htoi(char s[]);
int one_htoi(char c);

int main()
{
	printf("%d\n", htoi("318abc"));

	return 0;
}

int htoi(char s[])
{
	int n, i;

	n = 0;

	if (s[0] == '0' && tolower(s[1]) == 'x')
		i = 2;
	else
		i = 0;

	for (; s[i] != '\0'; ++i)
		n = 16 * n + one_htoi(s[i]);

	return n;
}

int one_htoi(char c)
{
	c = tolower(c);
	if (isdigit(c))
		return c - '0';
	else if (c == 'a')
		return 10;
	else if (c == 'b')
		return 11;
	else if (c == 'c')
		return 12;
	else if (c == 'd')
		return 13;
	else if (c == 'e')
		return 14;
	else if (c == 'f')
		return 15;
	else
		return -1;
}
