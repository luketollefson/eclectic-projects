#include <stdio.h>

/* exercises */
int main()
{
	printf("%d\n", getchar() != EOF);
	printf("%d\n", EOF);
}

/* copy input to output; 2nd version */
//int main()
//{
//	int c;
//
//	while((c = getchar()) != EOF)
//		putchar(c);
//
//	return 0;
//}

/* copy input to output; 1st version */
//int main()
//{
//	int c;
//
//	c = getchar();
//	while (c != EOF) {
//		putchar(c);
//		c = getchar();
//	}
//
//	return 0;
//}

//int main()
//{
////	char c;
//
//	char c = getchar();
//	/* puts a char, puts a char, printfs a char
//	   this isn't functional programming! */
//	printf("%c", putchar(putchar(c)));
////	putchar(c);
//
//	printf("\n");
//
//	return 0;
//}
