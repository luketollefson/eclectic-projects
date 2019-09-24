#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>

void error(char *fmt, ...);

int main(int argc, char *argv[])
{
	int f, n;
	char buf[BUFSIZ];

	if (argc < 2)
		error("Usage: cat file");
	while (--argc > 0)
		if ((f = open(*++argv, O_RDONLY, 0)) == -1)
			error("cat: can't open %s", *argv);
		else
			while ((n = read(f, buf, BUFSIZ)) > 0)
				if (write(1, buf, n) != n)
					error("cat: write error on file %s", *argv);

}

#include <stdarg.h>

/* error: print an error message and die */
void error(char *fmt, ...)
{
	va_list args;

	va_start(args, fmt);
	fprintf(stderr, "error: ");
	vfprintf(stderr, fmt, args);
	fprintf(stderr, "\n");
	va_end(args);
	exit(1);
}
