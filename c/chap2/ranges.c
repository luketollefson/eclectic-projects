#include <stdio.h>
#include <limits.h>
//#include <float.h>

unsigned long int pow2(unsigned long int base, unsigned long int exp);
int pow3(int base, int exp, int a);

int main()
{
	printf("unsigned char:\t0 to %d\n", UCHAR_MAX);
	printf("unsigned short:\t0 to %d\n", USHRT_MAX);
	printf("unsigned int:\t0 to %u\n", UINT_MAX);
	printf("unsigned long:\t0 to %lu\n", ULONG_MAX);
	printf("signed char:\t%d to %d\n", SCHAR_MIN, SCHAR_MAX);
	printf("signed short:\t%d to %d\n", SHRT_MIN, SHRT_MAX);
	printf("signed int:\t%d to %d\n", INT_MIN, INT_MAX);
	printf("signed long:\t%ld to %ld\n", LONG_MIN, LONG_MAX);
	putchar('\n');


	printf("unsigned char: 0 to %lu\n", pow2(2, CHAR_BIT) - 1);
	printf("unsigned short: 0 to %lu\n", pow2(2, 16) - 1);
	printf("unsigned int: 0 to %lu\n", pow2(2, 32) - 1);
	printf("unsigned long: 0 to %lu\n", pow2(2, 32) - 1);
	printf("signed char: %d to %d\n", pow3(2, CHAR_BIT-1, -1), pow3(2,CHAR_BIT-1, 1)-1);
	printf("signed short: %d to %d\n", pow3(2, 16-1, -1), pow3(2,16-1, 1)-1);
	printf("signed int: %d to %d\n", pow3(2, 32-1, -1), pow3(2,32-1, 1)-1);
	printf("signed long: %d to %d\n", pow3(2, 32-1, -1), pow3(2,32-1, 1)-1);

	return 0;
}

unsigned long int pow2(unsigned long int base, unsigned long int exp)
{
	unsigned long int i;
	unsigned long int answer = 1;
	
	for (i = 1; i <= exp; ++i)
		answer *= base;

	return answer;
}

int pow3(int base, int exp, int a)
{
	int i;
	int answer = 1 * a;

	for (i = 1; i <= exp; ++i)
		answer *= base;

	return answer;
}
