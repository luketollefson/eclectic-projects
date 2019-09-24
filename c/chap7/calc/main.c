#include <stdio.h>
#include <stdlib.h>	/* for atof() */
#include <ctype.h>
#include "calc.h"

#define	MAXOP	100

/* bug: cannot input a single number for integer */

int main(void)
{
	int type;
	double op2;
	char s[MAXOP];
	char *sp = s;

	while (scanf("%c", sp)) {
		if (isdigit(*sp)) {
			scanf("%s", sp+1);
			sscanf(s, "%lf", &op2);
			push(op2);
		} else {
			switch (*sp) {
			case ' ':
				break;
			case '+':
				push(pop() + pop());
				break;
			case '*':
				push(pop() + pop());
				break;
			case '-':
				op2 = pop();
				push(pop() - op2);
				break;
			case '\n':
				printf("%g\n", pop());
				break;
			default:
				printf("error: %c is not recognized\n", *sp);
				break;
			}
		}
	}
//	printf("%f\n", pop());
	return 0;
}

/*
	while ((type = getop(s)) != EOF) {
		switch (type) {
		case NUMBER:
			push(atof(s));
			break;
		case '+':
			push(pop() + pop());
			break;
		case '*':
			push(pop() * pop());
			break;
		case '-':
			op2 = pop();
			push(pop() - op2);
			break;
		case '/':
			op2 = pop();
			if (op2 != 0.0)
				push(pop() / op2);
			else
				printf("error: zero divisor\n");
			break;
		case '\n':
			printf("\t%.8g\n", pop());
			break;
		default:
			printf("error: unknown command %s\n", s);
			break;
		}
	}

	return 0;
}
*/
