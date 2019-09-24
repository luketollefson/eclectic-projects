#include <stdio.h>

#define	OUT	0	/* neither in a string or a comment */
#define STRING	1	/* inside of a quoted string */
#define CHAR	2	/* inside of a character */
#define COMMENT	3	/* inside of a comment */

void put_not_null(int c);

/* removes comments from a c program */
int main()
{
	int c, c2, state;

	c2 = '\0';
	state = OUT;
	while ((c = getchar()) != EOF) {
		if (state == OUT) {
			if (c == '\'') {
				state = CHAR;
				putchar(c);
			} else if (c == '"') {
				state = STRING;
				putchar(c);
			} else if (c == '/' && (c2 = getchar()) == '*') {
				state = COMMENT;
				c2 = '\0';
			} else {
				putchar(c);
				put_not_null(c2);
				c2 = '\0';
			}
		} else if (state == STRING) {
			if (c == '\\' && (c2 = getchar()) == '"')
				;
			else if (c == '"')
				state = OUT;
			putchar(c);
			put_not_null(c2);
			c2 = '\0';
		} else if (state == CHAR) {
			if (c == '\\' && (c2 = getchar()) == '\'')
				;
			else if (c == '\'')
				state = OUT;
			putchar(c);
			put_not_null(c2);
			c2 = '\0';
		} else if (state == COMMENT) {
			if (c == '*' && getchar() == '/')
				state = OUT;
		}
	}

	return 0;
}

void put_not_null(int c)
{
	if (c != '\0')
		putchar(c);
}
