#include <stdio.h>

void b_strut (void);

int i = 10;

int main(void)
{
	printf("%d\n", i);
	int i = 5;

	if (1) {
		printf("%d\n", i);
		static int i = 2;
		printf("%d\n", i);
		for (; i < 20; i++)
			;
			/* b_strut(); */
	}

	printf("%d\n", i);

	return 0;
}

/* testing out block structure */
void b_strut (void)
{
	static int n = 0;
	if (n > 5) {
		int i;

		for (i = 0; i < n; i++)
			printf("%d i", i);
	} else {
		printf("%d n\n", n);
	}
	n++;
}

/* f: using register variables, only works for
 * automatic variables (ones that come in and out
 * of existance and formal parameters of a functions
 * so a decleration like this:
 * register int i;
 * outside of a func do not compile.
 */
int f (register unsigned m, register long n)
{
	register int i;

	return 0;
}
