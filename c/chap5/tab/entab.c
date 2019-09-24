#include <stdio.h>
#include <stdlib.h>
#define MAXTABS	100	/* maximum number f tabstops */
#define	TABSTOP	8	/* default tabstop */

void print_blanks(int x);

/* replaces blanks with appropriate tabstops */
int main(int argc, char *argv[])
{
	int tabs[MAXTABS];
	int tabq[MAXTABS]; /* 0 means don't convert blanks, 1 means convert blanks */
	int startc = 1, everyc = 1; 

	while (--argc > 0 && ((*++argv)[0] == '-' || (*argv)[0] == '+'))
		if ((*argv)[0] == '-')
			startc = atoi((*argv)+1);
		else if ((*argv)[0] == '+')
			everyc = atoi((*argv)+1);

	for (int i = 0; i < startc; i++)
		tabq[i] = 0;
	for (int i = startc - 1; i < MAXTABS; i++) {
		tabq[i] = ((i - (startc - 1)) % everyc) ? 0 : 1;
	}

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
	int c, pos, blanks, *t_stop;

	t_stop = tabs;

	blanks = 0;
	for (pos = 1; (c = getchar()) != EOF; ++pos) {
		if (c == ' ') {
			if (pos == *t_stop) {
				pos = 0;
				if (tabq[t_stop - tabs]) {
					putchar('\t');
					blanks = 0;
				} else {
					print_blanks(blanks+1);
					blanks = 0;
				}
				t_stop++;
			} else
				++blanks;
		} else if (c == '\n') {
			putchar('\n');
			pos = 0;
			blanks = 0;
			t_stop = tabs;
		} else if (c == '\t') {
			putchar('\t');
			pos = 0;
			blanks = 0;
			t_stop++;
		} else {
			print_blanks(blanks);
			blanks = 0;
			putchar(c);
			pos %= *t_stop;
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
