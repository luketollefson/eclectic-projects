#include <stdio.h>
#define MAXLINE	1000	/* maximum input line size */

int get_clear_line(char s[], int maximum);

/* deletes trailing whitespace and empty newlines */
int main()
{
	char line[MAXLINE];	/* current input line */

	while (get_clear_line(line, MAXLINE) > 0)
		printf("%s", line);

	return 0;
}

/* get_clear_line: read a single line into s and
		   removes traliing whitespace */
int get_clear_line(char s[], int lim)
{
	int len; /* length without trailing whitespace */
	int c, i;

	len = 0;
	for (i=0; i<lim-1 && (c=getchar())!=EOF && c!='\n'; ++i)
	{
		s[i] = c;
		if (c != ' ' && c != '\t')
			len = i + 1; 
	}

	if (c == '\n' && len == 0) {
		s[len] = '\0';
		++len;
	} else if (c == '\n') {
		s[len] = '\n';
		s[++len] = '\0';
		++len;
	}

	return len;
}
/* n
i
c
e */
