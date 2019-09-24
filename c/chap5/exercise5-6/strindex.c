#include <stdio.h>

char *strindex(const char *haystack, const char *needle);

int main(void)
{
	char s[] = "Hello world!";
	char *p = strindex(s, "x");

	if (p)
		printf("%c %d\n", *p, p - s);
	else
		printf("String not part of string\n");

	return 0;
}

char *strindex(const char *haystack, const char *needle)
{
	const char *needle0 = needle;

	for ( ; *haystack != '\0'; haystack++) {
		for (needle=needle0; *needle!='\0' && *haystack==*needle; haystack++, needle++)
			;
		if (needle > needle0 && *needle == '\0')
			return (char *) haystack - (needle-needle0);
	}
	return NULL;
}
