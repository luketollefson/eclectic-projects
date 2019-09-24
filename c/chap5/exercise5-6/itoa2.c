#include <stdio.h>

char *itoa2(char *dest, int src);

int main(void)
{
	char s[100];
	itoa2(s, -2147483648);
	printf("%s\n", s);

	return 0;
}

char *itoa2(char *dest, int src)
{
	if (src / 10)
		dest = itoa2(dest, src / 10);
	else if (src < 0) {
		dest++;
		*(dest-1) = '-';
	}

	if (src > 0) {
		*dest = src % 10 + '0';
		*(dest+1) = '\0';
	} else {
		*dest = -(src % 10) + '0';
		*(dest+1) = '\0';
	}

	return ++dest;
}

#include <stdlib.h>

/* itoa2: converts int src into string dest, the output is reverse of what it ought be 
void itoa2(char *dest, int src)
{
	if (src < 0)
		*dest++ = '-';
	do {
		*dest++ = abs(src % 10) + '0';	
	} while ((src /= 10) > 0);
	*dest = '\0';
}
*/


