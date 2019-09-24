#include <stdio.h>
#define MINLINE	80	/* minimum line length */
#define MAXLINE	1000	/* maximum input size */

int getline2(char s[], int maxline);

/* print lines longer than 80 characters */
int main()
{
	int len;	/* length of the line */
	char line[MAXLINE];	/* current input line */

	while ((len = getline2(line, MAXLINE)) > 0)
		if (len >= MINLINE)
			printf("%s", line);
	return 0;
}

/* getline: read a line into s, return length */
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
