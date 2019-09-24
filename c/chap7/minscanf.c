#include <stdio.h>

void minscanf(char *fmt, ...);

int main(void)
{
	int i;	
	minscanf("%d", &i);

	printf("%d\n", i+10);

	return 0;
}

#include <stdarg.h>
/* minscanf: minimal scanf with variable argument list */
void minscanf(char *fmt, ...)
{
	va_list ap;
	char *p, *sval;
	int *ival;
	float *fval;

	va_start(ap, fmt);
	for (p = fmt; *p; p++) {
		if (*p != '%') {
			continue;
		}
		switch (*++p) {
		case 'd':
			ival = va_arg(ap, int *);
			scanf("%d", ival);
			break;
		case 'f':
			fval = va_arg(ap, float *);
			scanf("%f", fval);
			break;
		default:
			printf("error: unknown conversion char %c\n", *p);
			break;
		}
	}
	va_end(ap);
}
