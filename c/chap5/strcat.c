#include <stdio.h>

int main(void)
{
	void strcat2(char *, const char *);

	char s[100] = "hello world";
	s[5] = '\0';

	strcat2(s, "why hello");

	printf("%s\n", s);

	int strend(const char *, const char *);

	printf("%d\n", strend("", ""));

	return 0;
}

/* strcat: concatenate t to end of s; must be big enough */
void strcat2(char *s, const char *t)
{
	while (*s)
		s++;
	while (*s++ = *t++)
		;
}

/* strend: return 1 if string t occurs at the end of string s, zero otherwise */
int strend(const char *s, const char *t)
{
	if (!*t)
		return 1;
	int i;
	while (*s) {
		i = 0;
		while (*s == *(t+i)) {
			if (*s == '\0')
				return 1;
			s++, i++;
		}
		s++;
	}
	return 0;
}
