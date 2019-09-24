#include <unistd.h>
#include <stdio.h>

//#define BUFSIZ	1000


int main(void)	/* copy input to output */
{
	printf("%d\n", BUFSIZ);
	char buf[BUFSIZ];
	int n;

	while ((n = read(0, buf, BUFSIZ)) > 0)
		write(1, buf, n);
	return 0;
}

/* getchar: unbuffered single character input */
int getchar(void)
{
	char c;

	return (read(0, &c, 1) == 1) ? (unsigned char) c : EOF;
}

/* getcharbuf:  simple buffered version */
int getchar(void)
{
	static char buf[BUFSIZ];
	static char *bufp = buf;
	static int n = 0;

	if (n == 0) {	/* buffer is empty */
		n = read(0, buf, sizeof buf);
		bufp = buf;
	}
	return (--n >= 0) ? (unsigned char) *bufp++ : EOF;
}
