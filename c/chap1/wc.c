#include <stdio.h>

#define	IN	1	/* inside a word */
#define	OUT	0	/* outside a word */

/* print one word per line */
int main()
{
	int c, state;

	state = OUT;
	while ((c = getchar()) != EOF) {
		if (c == ' ' || c == '\n' || c == '\t') {
			if (state == IN)
				putchar('\n');
			state = OUT;
		} else {
			state = IN;
			putchar(c);
		}
	}

	return 0;
}

/* count lines, words, and characters in input */
//int main()
//{
//	int c, nl, nw, nc, state;
//
//	state = OUT;
//	nl = nw = nc = 0;
//	while ((c = getchar()) != EOF) {
//		++nc;
//		if (c == '\n')
//			++nl;
//		if (c == ' ' || c == '\n' || c == '\t')
//			state = OUT;
//		else if (state == OUT) {
//			state = IN;
//			++nw;
//		}
//	}
//	printf("%d %d %d\n", nl, nw, nc);
//
//	return 0;
//}
