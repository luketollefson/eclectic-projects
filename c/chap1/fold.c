#include <stdio.h>
#define	MAXLENGTH	40	/* maximum length of column */
#define	IN	1	/* inside a word */
#define OUT	0	/* outside a word */

int c, pos, length, blanks, state;
char word[MAXLENGTH];

void print_head (char s[], int length, int maxlen);
void print_blanks(int x);

/* fold.c: wraps long lines after MAXLENGTH */
int main()
{
	extern int c, pos, length, blanks, state;
	extern char word[MAXLENGTH];

	/* seperate the input into words, and print when the next word starts */

	state = OUT;
	length = blanks = 0;
	for (pos = 1; (c = getchar()) != EOF; ++pos) {
		if (pos + length > MAXLENGTH) {
			putchar('\n');
			pos = 0;
			blanks = 0;
		} else if (c == '\n') {
			putchar('\n');
			print_head(word, length, MAXLENGTH);
			pos = length;
			length = 0;
			blanks = 0;
		} else if (c == ' ') {
			state = OUT;
			length = 0;
			++blanks;
		} else {
			if (state == OUT) {
				print_blanks(blanks);
				print_head(word, length, MAXLENGTH);
				length = 0;
			}	
			state = IN;
			word[length] = c;
			blanks = 0;
			++length;
		}
	}

	return 0;
}

/* next_word: reads a word into s, returns length */
void next_word(char s[])
{
	extern c, length, blanks;
	int i;

	for (i = 0; (c = getchar()) != EOF), ++i)

	for (int i = 0; (c = getchar()) != EOF), ++i)
	{
		if (c == '\n') {
			break;
		} else if (c == ' ') {
			++blanks;
			break;
		} else {
			s[length] = c;
			++length;
			s[length] = '\0';
	}
}

void print_head(char s[], int len, int maxlen)
{
	if (len < maxlen)
		s[len] = '\0';
	printf("%s", s);
}

void print_blanks(int x) 
{
	for (int i = 1; i <= x; ++i)
		putchar(' ');
}
