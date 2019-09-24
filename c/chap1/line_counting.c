#include <stdio.h>

/* exercise 1-10
int main()
{
	int c;

	while ((c = getchar()) != EOF)
	{
		if (c == '\t')
			printf("\\t");
		else if (c == '\b')
			printf("\\b");
		else if (c == '\\')
			printf("\\\\");
		else
			putchar(c);
	}

	return 0;
}

/* exercise 1-9, copy input to output, replace multiple blanks with only one blank; version 1 */
//int main()
//{
//	int c;
//
//	while ((c = getchar()) != EOF)
//	{
//		if (c == ' ')
//		{
//			while ((c = getchar()) == ' ')
//				;
//			putchar(' ');
//		}
//		putchar(c);
//	}
//
//	return 0;
//}

/* exercise 1-8, count blanks, tabs, and newlines */
//int main()
//{
//	int c, b, t, nl;
//
//	b = t = nl = 0;
//	while ((c = getchar()) != EOF)
//	{
//		if (c == ' ')
//			++b;
//		if (c == '\t')
//			++t;
//		if (c == '\n')
//			++nl;
//	}
//	printf("%3d %3d %3d\n", b, t, nl);
//
//	return 0;
//}

/* counts lines in input */
//int main()
//{
//	int c, nl;
//
//	nl = 0;
//	while ((c = getchar()) != EOF)
//		if (c == '\n')
//			nl++;
//	printf("%d\n", nl);
//
//	return 0;
//}
