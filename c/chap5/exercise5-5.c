#include <stdio.h>
#include <string.h>

char *strncpy2(char *dest, const char *src, size_t n);
char *strncat2(char *dest, const char *src, size_t n);
int strncmp2(const char *s1, const char *s2, size_t n);

int main(void)
{
	char s[100] = "hello world";

	/*
	printf("%c\n", *strncpy(s, "", 0));
	printf("%s\n", s);

	printf("%c\n", *strncat(s, "wallogallo", 0));
	printf("%s\n", s);
	*/
	printf("%d\n", strncmp("", "a", 4802));

	return 0;
}

/* strncpy2: copy at most n bytes from string src to dest, returning a pointer to the start of dest */
char *strncpy2(char *dest, const char *src, size_t n)
{
	for (size_t i = 0; i < n && (*(dest+i) = *(src+i)); i++)
		;
	return dest;
}

/* strncat2: append at most n characters from string src to string dest, returing a pointer to dest */
char *strncat2(char *dest, const char *src, size_t n)
{
	char *ret_dest = dest;
	while (*dest)
		dest++;
	for (size_t i = 0; i < n && (*dest++ = *src++); i++)
		;
	return ret_dest;
}

/* strncmp2: compare at most n bytes of the strings s1 and s2 */
int strncmp2(const char *s1, const char *s2, size_t n)
{
	size_t i;
	for (i = 0; i < n && *s1 == *s2; i++, s1++, s2++)
		if (*s1 == '\0')
			return 0;
	if (i >= n)
		return 0;
	return *s1 - *s2;
}
