#include <stdio.h>
#define MAXLINE	1000	/* maximum input line length */

int strrindex(char s[], char t[]);
int getline2(char s[], int lim);

char pattern[] = "ould";	/* pattern to search for */

/* find all lines matching pattern */
int main()
{
	int index;
	char line[MAXLINE];
	int found = 0;

	while (getline2(line, MAXLINE) > 0)
		if ((index = strrindex(line, pattern)) >= 0) {
			printf("%3d %s", index, line);
			found++;
		}

	return found;
}

/* strrindex: return the index of the rightmost occurrance of t */
int strrindex(char s[], char t[])
{
	int i, j, k, rindex;
	rindex = -1;

	for (i = 0; s[i] != '\0'; i++) {
		for (j=i, k=0; t[k]!='\0' && s[j]==t[k]; j++, k++)
			;
		if (k > 0 && t[k] == '\0')
			rindex = i;
	}
	return rindex;
}

/* getline2: get line into s, return length */
int getline2(char s[], int lim)
{
        int c, i;

        i = 0;
        while (--lim > 0 && (c=getchar()) != EOF && c != '\n')
                s[i++] = c;
        if (c == '\n')
                s[i++] = c;
        s[i] = '\0';
        return i;
}
