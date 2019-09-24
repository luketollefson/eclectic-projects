#include <stdio.h>
#include <stdlib.h>
#define MAXTABS	100	/* maximum number of tabstops */
#define	TABSTOP	8	/* tabstop value */

/* replaces tabstops with the proper number of spaces */
int main(int argc, char *argv[])
{
	int tabs[MAXTABS];

	if (argc > 1) {
		argc--;
		for (int i = 0; i < MAXTABS; i++) {
			if (argc) {
				argv++;
				argc--;
			}
			tabs[i] = atoi(*argv);
		}
	} else
		for (int i = 0; i < MAXTABS; i++)
			tabs[i] = TABSTOP;
	int c, pos, *t_stop;

	t_stop = tabs;
	for (pos = 1; (c = getchar()) != EOF; ++pos) {
		if (c == '\t') {
			for (; pos <= *t_stop; ++pos)
				putchar(' ');
			pos = 0;
			t_stop++;
		} else if (c == '\n') {
			putchar('\n');
			pos = 0;
			t_stop = tabs;
		} else {
			putchar(c);
			pos %= *t_stop;
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
