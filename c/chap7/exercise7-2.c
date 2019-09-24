#include <stdio.h>
#include <ctype.h>

#define MAXLEN	100	/* maximum line length */

int main(void)
{
	int c, linelen;

	linelen = 0;
	while ((c = getchar()) != EOF)
		if (c == '\n' || linelen == MAXLEN) {
			putchar(c);
			linelen = 0;
		} else if (c == '\t') {
			putchar(c);
			linelen += (8 - linelen % 8);
		} else if (isprint(c)) {
			putchar(c);
			linelen++;
		} else {
			printf("0x%x", c);
			linelen += 2 + c / 16 + (c % 16 ? 0 : 1);
		}

	return 0;
}
