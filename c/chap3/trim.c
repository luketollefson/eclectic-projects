#include <stdio.h>
#include <string.h>

int trim(char s[]);

int main()
{
	char s[] = "Helllo, World     ";
	trim(s);

	printf("%sh\n", s);
	if (0)
		printf("hi\n");

	help:
	printf("help\n");
	
	goto help;

	return 0;
}

/* trim: remove trailing blanks, tabs, newlines */
int trim(char s[])
{
	int n;

	for (n = strlen(s)-1; n >= 0; n--)
		if (s[n] != ' ' && s[n] != '\t' && s[n] != '\n')
			break;
	s[n+1] = '\0';
	return n;
}
