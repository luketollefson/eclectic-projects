#include <stdio.h>

double atof2(const char *s);

int main(void)
{
	printf("%g\n", atof2("123.456e-10"));

	return 0;
}

#include <ctype.h>
#include <math.h>

double atof2(const char *s)
{
	for ( ; isblank(*s); s++)
		;
	
	double val = 0;
	for ( ; isdigit(*s); s++)
		val = 10 * val + (*s - '0');

	int dec = 0;
	if (*s == '.') {
		s++;
		for ( ; isdigit(*s); s++) {
			val = 10 * val + (*s - '0');
			dec++;
		}
	}

	int exp = 0;
	if (*s == 'e' || *s == 'E') {
		s++;
		if (*s == '-') {
			s++;
			for ( ; isdigit(*s); s++)
				exp = 10 * exp - (*s - '0');
		}
		if (*s == '+') {
			s++;
			for ( ; isdigit(*s); s++)
				exp = 10 * exp + (*s - '0');
		}
		if (isdigit(*s)) {
			for ( ; isdigit(*s); s++)
				exp = 10 * exp + (*s - '0');
		}
	}

	return (val / pow(10, dec)) * pow(10, exp);
}
