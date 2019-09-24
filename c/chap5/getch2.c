#include <stdio.h>

#define BUFSIZE	100

static int buf[BUFSIZE];
static int bufp = 0;

int getch2(void) /* get a (possibly pushed back) character */
{
	return (bufp > 0) ? buf[--bufp] : getchar();
}

void ungetch2(int c) /* push character back on input */
{
	if (bufp >= BUFSIZE)
		printf("ungetch2: too many characters\n");
	else
		buf[bufp++] = c;
}
