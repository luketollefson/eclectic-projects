#include <stdio.h>

int main(void)
{
	char s[] = "hello world\0what is going on today";
	printf("%s\n", s+1);

	return 0;
}
