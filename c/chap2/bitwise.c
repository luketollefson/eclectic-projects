#include <stdio.h>

unsigned getbits(unsigned x, int p, int n);
unsigned setbits(unsigned x, int p, int n, unsigned y);
unsigned invert(unsigned x, int p, int n);
unsigned rightrot(unsigned x, int n);
int bitcount(unsigned x);

int main()
{
	int x = 047123;

	/* the bitwise AND operator & being used as a mask */
	printf("%o %o\n", x, x & 057700);
	printf("%o %o\n", 03, 03 & 04);

	int y = 0777;

	printf("%o\n", y >> 1);

	printf("%o\n", 0777 & ~077);

	printf("%o\n", getbits(01234567, 17, 9));

	printf("%o\n", setbits(01111111, 14, 9, 01234567));

	printf("%o\n", invert(01111111, 14, 9));

	printf("%o\n", rightrot(012345671234, 3));

	printf("%d\n", bitcount(01));

	return 0;
}

/* getbits: get n bits from position p, position 0 is right end, n counts right */
unsigned getbits(unsigned x, int p, int n)
{
	return (x >> (p+1-n)) & ~(~0 << n);
}

/* setbits: set n bits from position p to the rightmost bits of y */
unsigned setbits(unsigned x, int p, int n, unsigned y)
{
	unsigned mask = ~0 << p+1-n ^ ~0 << p+1;
	return (x & ~mask) | (y << p+1-n & mask);
}

unsigned invert(unsigned x, int p, int n)
{
	unsigned mask = ~0 << p+1-n ^ ~0 << p+1;
	return x ^ mask;
}

unsigned rightrot(unsigned x, int n)
{
	return x >> n | x << 32 - n;
}

/* bitcount: count 1 bits in x */
/*
int bitcount(unsigned x)
{
	int b;

	for (b = 0; x != 0; x >>= 1)
		if (x & 01)
			b++;
	return b;
}
*/

/* faster vserion of bitcount */
int bitcount(unsigned x)
{
	int b;
	
	for (b = 1; x &= (x-1); ++b)
		;

	return b;
}
