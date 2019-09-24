#include <stdio.h>
#include <ctype.h>

void expand(char s1[], char s2[]);

int main()
{
	char s1[1000], s2[1000];
	int c, i;
	for (int i = 0; (c = getchar()) != EOF; i++)
		s1[i] = c;
	expand(s1, s2);
	printf("%s", s2);

	return 0;
}

void expand(char s1[], char s2[])
{
	int i, j, k;
	

	/* fixes an issue where if the first char is '-' garbage is stored in s2[-1] */
	i = j = 0;
	if (s1[i] == '-')
		s2[j++] = s1[i++];

	for (; s1[i] != '\0'; i++)
		if (s1[i] == '-')
			if (isdigit(s1[i-1]) && isdigit(s1[i+1]) && s1[i-1] < s1[i+1])
				for (k = s1[i-1] + 1; k < s1[i+1]; k++)
					s2[j++] = k;
			else if (islower(s1[i-1]) && islower(s1[i+1]) && s1[i-1] < s1[i+1])
				for (k = s1[i-1] + 1; k < s1[i+1]; k++)
					s2[j++] = k;
			else if (isupper(s1[i-1]) && isupper(s1[i+1]) && s1[i-1] < s1[i+1])
				for (k = s1[i-1] + 1; k < s1[i+1]; k++)
					s2[j++] = k;
			else
				s2[j++] = '-';
		else
			s2[j++] = s1[i];

	s2[j] = '\0';
}
