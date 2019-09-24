#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

#define MAXOP 100

int main(int argc, char *argv[])
{
	int val1, val2, *s, stack[MAXOP];

	s = stack;
	while (++argv, --argc > 0) {
		if (isdigit(*argv[0])) {
			*s++ = atoi(*argv);
			continue;
		}
		switch (*argv[0]) {
		case '+':
			val1 = *--s;
			val2 = *--s;
			*s++ = val2 + val1;
			break;
		case '-':
			if (strlen(*argv) != 1) {
				*s++ = atoi(*argv);
				break;
			}
			val1 = *--s;
			val2 = *--s;
			*s++ = val2 - val1;
			break;
		case '*':
			val1 = *--s;
			val2 = *--s;
			*s++ = val2 * val1;
			break;
		case '/':
			val1 = *--s;
			val2 = *--s;
			*s++ = val2 / val1;
			break;
		default:
			printf("Invalid operation: %s\n", *argv);
			break;
		}
	}
	printf("%d\n", *(s-1));
	return 0;
}
