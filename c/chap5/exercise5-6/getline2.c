#include <stdio.h>

int getline2(char *s, size_t lim);

int main(void)
{
	char s[100];
	printf("%d\n", getline2(s, 100));

	printf("%s", s);

	return 0;
}

int getline2(char *s, size_t lim)
{
	size_t i;

	for (i = 0; i < lim - 1 && (*(s+i) = getchar()) != EOF && *(s+i) != '\n'; i++)
		;
	if (*(s+i) == '\n')
		i++;
	*(s+i) = '\0';
	return i;
}
