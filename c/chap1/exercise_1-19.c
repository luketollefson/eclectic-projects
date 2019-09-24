#include <stdio.h>
#define	MAXLINE	1000	/* maximum input line size */

void reverse(char to[], char from[]);
int getline2(char s[], int lim);

/* reverses input one line a time */
int main()
{
	char to[MAXLINE];
	char from[MAXLINE];
	
	while(getline2(from, MAXLINE) > 0)
	{
		reverse(to, from);
		printf("%s", to);
	}

	putchar('\n');
	
	return 0;
}

/* getline2: read a line into s, return length */
int getline2(char s[], int lim)
{
	int c, i;

	for (i=0; i<lim-1 && (c=getchar())!=EOF && c!='\n'; ++i)
		s[i] = c;
	if (c == '\n') {
		s[i] = c;
		++i;
	}
	s[i] = '\0';

	return i;
}

/* reverse: reverses a character string */
void reverse(char to[], char from[])
{
	int i, length;

	length = 0;
	for (i = 0; from[i] != '\0'; ++i)
		++length;

	for (i = 0; i < length; i++)
		to[i] = from[length - i - 1];	

	to[length] = '\0';
}
