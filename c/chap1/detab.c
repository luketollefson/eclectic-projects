#include <stdio.h>
#define	TABSTOP	8	/* tabstop value */

/* replaces tabstops with the proper number of spaces */
int main()
{
	int c, pos;

	for (pos = 1; (c = getchar()) != EOF; ++pos) {
		if (c == '\t') {
			for (; pos <= TABSTOP; ++pos)
				putchar(' ');
			pos = 0;
		} else if (c == '\n') {
			putchar('\n');
			pos = 0;
		} else {
			putchar(c);
			pos %= TABSTOP;
		}
	}

	return 0;
}

///* replaces tabstops with the proper number of spaces */
//int main()
//{
//	int pos;
//	char c, tsblock[TABSTOP];
//
//	pos = 0;
//	for (; (c = getchar()) != EOF; ++pos) {
//		if (c == '\t')
//			for (; pos < TABSTOP; ++pos)
//				tsblock[pos] = ' ';	
//		else
//			tsblock[pos] = c;
//
//		if (pos >= 7) {
//			printf("%s", tsblock);
//			pos = 0;
//		}
//			//printf("%d", pos);
//	}
//
//	char test[] = "hellotoo";
//	printf("\n%c\n%s\n", test[0], test);
//
//	return 0;
//}
