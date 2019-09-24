#include <stdio.h>

#define MAXCHAR	1000 /* maximum number of charactrers */

void escape(char s[], char t[]);
void escape2(char s[], char t[]);

int main()
{
	char s[MAXCHAR], t[MAXCHAR];

	int c;
	for (int i = 0; i < MAXCHAR && (c = getchar()) != EOF; i++)
		t[i] = c;
	

	escape2(s, t);
	printf("%s", s);

	return 0;
}

/* escape: takes t and converts newlines and tabs into visable \n and \t and puts it in s */
void escape(char s[], char t[])
{
	int si = 0;
	for (int ti = 0; t[ti] != '\0'; ti++) {
		switch (t[ti]) {
			case '\n':
				s[si++] = '\\';
				s[si++] = 'n';
				s[si++] = '\n';
				break;
			case '\t':
				s[si++] = '\\';
				s[si++] = 't';
				s[si++] = '\t';
				break;
			default:
				s[si++] = t[ti];
				break;
		}
	}
	s[si] = '\0';
}

/* escape2: takes t and converts "\n" and "\t" into actual newlines and tabs */
void escape2(char s[], char t[])
{
	int si = 0;
	for (int ti = 0; t[ti] != '\0'; ti++) {
		switch (t[ti]) {
			case '\\':
				switch (t[++ti]) {
				case 'n':
					s[si++] = '\n';
					break;
				case 't':
					s[si++] = '\t';
					break;
				default:
					s[si++] = '\\';
					s[si++] = t[ti];
					break;
				}
				break;
			default:
				s[si++] = t[ti];
				break;
		}
	}
	s[si] = '\0';
}
