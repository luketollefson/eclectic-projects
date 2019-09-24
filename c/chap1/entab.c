#include <stdio.h>
#define	TABSTOP	8	/* width of tabstop */

void print_blanks(int x);

/* replaces blanks with appropriate tabstops */
int main()
{
	int c, pos, blanks;

	blanks = 0;
	for (pos = 1; (c = getchar()) != EOF; ++pos) {
		if (c == ' ') {
			if (pos == TABSTOP) {
				putchar('\t');
				pos = 0;
				blanks = 0;
			} else
				++blanks;
		} else if (c == '\n') {
			putchar('\n');
			pos = 0;
			blanks = 0;
		} else if (c == '\t') {
			putchar('\t');
			pos = 0;
			blanks = 0;
		} else {
			print_blanks(blanks);
			blanks = 0;
			putchar(c);
			pos %= TABSTOP;
		}
	}

	return 0;
}

/* prints however many blanks */
void print_blanks(int x)
{
	for (int i = 1; i <= x; ++i)
		putchar(' ');
}

///* replaces blanks with appropriate tabstops */
//int main()
//{
//	int c, pos, len;
//	char tsblock[TABSTOP];
//
//	for (pos = 0; (c = getchar()) != EOF; ++pos) {
//		if (c == '\n') {
//			putchar('\n');
//			pos = 0;
//		} else if (c == ' ')
//			++pos;
//		else {
//			tsblock[pos] = c;
//			len = pos;
//		}
//		if (pos >= TABSTOP - 1) {
//			if (len == TABSTOP - 1)
//				;
//			else if (len == TABSTOP-2)
//				tsblock[TABSTOP-1] = '\t';
//			else {
//				tsblock[len+1] = '\t';
//				tsblock[len+2] = '\0';
//			}
//			printf("%s", tsblock);
//			pos = 0;
//		}
//	}
//
//	return 0;
//}
