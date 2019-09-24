#include <stdio.h>

int main()
{
	int c, i, lim, state;
	char s[1000];
	lim = 1000+1;
	state = 1;
	for (i=0; i<lim-1 && (c=getchar()) != '\n' && c != EOF; ++i)
		s[i] = c;

	/* for loop equivilant wihout using && or || */
	/*
	for (i=0; state; ++i)
		if (i<lim-1)
			if ((c=getchar()) != '\n')
				if (c!=EOF)
					s[i] = c;
				else
					state = 0;
			else
				state = 0;
		else
			state = 0;
		
	*/

	printf("%s\n", s);
	return 0;
}
