#include <stdio.h>
#include <string.h>

int main()
{
	char hello[300] = "hello world";
	char ello[300] = "hello world";
	if (strcmp(hello,ello) == 0)
		printf("yes\n");
	else
		printf("no\n");
	if (0)
		printf("hi");
	else
		printf("bye");
	return 0;
}
