#include <stdio.h>

void reverse(char *);

int main(void)
{
	char s[] = "hello world";
	reverse(s);
	printf("%s\n", s);

	return 0;
}

#include <string.h>

void reverse(char *p)
{
	char *q;
	int c;

	for (q = p + strlen(p)-1; p < q; p++, q--) {
		c = *p;
		*p = *q;
		*q = c;
	}
}

/*
char *reverse(char *sh)
{
	char *st = sh;
	if (*sh != '\0')
		st = reverse(++sh);
	else
		return sh;

	char c;
	c = *sh;
	*sh = *st;
	*st = c;

	return st-1;
}
*/
