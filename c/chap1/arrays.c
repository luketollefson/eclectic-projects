#include <stdio.h>

#define MAX_WORD_LENGTH	25

/* historgram of word lengths */
int main()
{
	int c, i;
	int freq[MAX_WORD_LENGTH+1];

	for (i = 1; i < MAX_WORD_LENGTH+1; ++i)
		freq[i] = 0;

	i = 0;
	while ((c = getchar()) != EOF)
	{
		if (c != ' ' && c != '\n' && c != '\t')
			++i;
		else
			if (i != 0) {
				++freq[i];
				i = 0;
			}
	}

	/* simple table output */
	printf("freqencies =");
	for (i = 1; i < MAX_WORD_LENGTH+1; ++i)
		printf(" %d", freq[i]);

	printf("\n");

	/* horizontal histogram of frequencies */
	for (i = 1; i < MAX_WORD_LENGTH+1; ++i)
	{
		printf("%d\t", i);
		for (int n = 0; n < freq[i]; ++n)
			putchar('-');
		putchar('\n');
	}

	printf("\n");

	/* vertical histogram of frequencies */
	int high;

	/* find the highest value */
	high = 0;
	for (i = 1; i < MAX_WORD_LENGTH+1; ++i)
	{
		if (freq[i] > high)
			high = freq[i];
	}

	/* print the vertical histogram */
	for (;high > 0; --high)
	{
		for (i = 1; i < MAX_WORD_LENGTH+1; ++i)
		{
			if (freq[i] >= high)
				printf(" |");
			else
				printf("  ");
		}
		putchar('\n');
	}

	/* print the numbers */
	for (i = 1; i < MAX_WORD_LENGTH+1; ++i)
		if (i < 10)
			printf("  ");
		else
			printf(" %d", i/10);

	putchar('\n');

	for (i = 1; i < MAX_WORD_LENGTH+1; ++i)
		printf(" %d", i % 10);
	
	putchar('\n');

	return 0;
}

/* count digits, white space, other */
//int main()
//{
//	int c, i, nwhite, nother;
//	int ndigit[10];
//
//	nwhite = nother = 0;
//	for (i = 0; i < 10; ++i)
//		ndigit[i] = 0;
//
//	while ((c = getchar()) != EOF)
//		if (c >= '0' && c <= '9')
//			++ndigit[c-'0'];
//		else if (c == ' ' || c == '\n' || c == '\t')
//			++nwhite;
//		else
//			++nother;
//
//	printf("digits =");
//	for (i = 0; i < 10; ++i)
//		printf(" %d", ndigit[i]);
//	printf(", white space = %d, other = %d\n",
//		nwhite, nother);
//
//	return 0;
//}
