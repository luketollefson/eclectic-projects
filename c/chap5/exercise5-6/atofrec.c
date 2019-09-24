#include <stdio.h>
#include <math.h>

int atoi2(const char *s);
int atobi2(const char *s);

int main(void)
{
	printf("%d\n", atobi2("38167"));

	return 0;
}

#include <ctype.h>


/* atof: convert string s to double */
double atof(char *s)
{
	double val;
	if (*s == '-')
		return -atof(s+1);
	if (isdigit(*s))
		return atoi2(s);
	if (*s == '.') {
		return (double) atoi2(s);
		val += (*s - '0') + atof(s+1) / 10;
	}

	if (*s == 'e' || *s == 'E') {
		s++;
		if (*s == '-') {
			s++;
			val *= pow(10, -atof(s+1));
		}
		if (*s == '+') {
			s++;
			val *= pow(10, atof(s+1));
		}
	}

	return val;
}

/* atobi2: convert string s into backward int */
int atobi2(const char *s)
{
	if (isdigit(*s))
		return 10 * atobi2(s+1) + (*s - '0');

	/* else */
	return 0;
}

/* atoi2: convert string s to int */
int atoi2(const char *s)
{
	if (*s == '+')
		return atoi2(s+1);
	if (*s == '-')
		return -atoi2(s+1);
	if (isdigit(*s)) {
		const int r = atoi2(s+1); 	/* less significant digit(s) */
		const int mag = pow(10, (int) (r ? log10(r)+1 : 0));	/* magnitude of significant digit */
		return (*s - '0') * mag + r;
	}

	/* else */
	return 0;
}
