#include <stdio.h>
#include <ctype.h>
#include "calc.h"

/* getop: get next operator or numeric operand */
int getop(char s[])
{
	static int c = '\0';
	int i, c2;

	if (c == '\0')
		s[0] = c = getch();

	s[0] = c;

	while (isblank(c))
		s[0] = c = getch();	
	s[1] = '\0';
	if (!isdigit(c) && c != '.') {	/* not a number */
		c2 = c;
		c = '\0'; /* unable to getch() here as it interrupts the program */
		return c2;	
	}
	i = 0;
	while (isdigit(c))	/* collect integer part */
		s[++i] = c = getch();
	if (c == '.')		/* collect fraction part */
		while (isdigit(c))
			s[++i] = c = getch();	
	s[i] = '\0';
	return NUMBER;
}

///* getop: get next operator or numeric operand */
//int getop(char s[])
//{
//	int i, c;
//
//	while ((s[0] = c = getch()) == ' ' || c == '\t')
//		;
//	s[1] = '\0';
//	if (!isdigit(c) && c != '.')
//		return c;	/* not a number */
//	i = 0;
//	if (isdigit(c))		/* collect integer part */
//		while (isdigit(s[++i] = c = getch()))
//			;
//	if (c == '.')		/* collect fraction part */
//		while (isdigit(s[++i] = c = getch()))
//			;
//	s[i] = '\0';
//	if (c != EOF)
//		ungetch(c);
//	return NUMBER;
//}
