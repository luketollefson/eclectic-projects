#include <stdio.h>

#define MAXNEST	100	/* maximum nesting of syntax */
#define	NESCSEQ	0	/* the character is treated normally */
#define ESCSEQ	1	/* the character is part of an escape sequence */
#define OUT	0	/* outside of any syntax */
#define PARENTH	1	/* inside parentheses */
#define BRACE	2	/* inside braces */
#define BRACKET	3	/* inside brackets */
#define SINQUOT	4	/* inside single quotes */
#define DOUQUOT	5	/* inside double quotes */	
#define NCOMMEN 6	/* not in comment */
#define PCOMMEN 7	/* partially in a comment */
#define ICOMMEN	8	/* inside of a comment */

/*void check_char(int c, int const_c, int type);*/
void print_error(int line, int error);

/* syntaxcheck.c: checks for rudimentary syntax errors */
int main()
{
	int c, c2, esc, line, stack[MAXNEST], error[MAXNEST], spos, com;

	com = NCOMMEN;
	error[0] = 1;
	line = 1;
	spos = 0;
	stack[spos] = OUT;
	while ((c = getchar()) != EOF) {
		if (c == '*' && com == PCOMMEN && com != ICOMMEN) {
			com == ICOMMEN;
			++spos;
			stack[spos] = ICOMMEN;
			error[spos] = line;
		} else if (com != ICOMMEN) {
			com = NCOMMEN;
		}
		if (stack[spos] == ICOMMEN) {
			if (c == '*' && getchar() == '/') {
				com == NCOMMEN;
				--spos;
			}
		} else if (esc == ESCSEQ) {
			esc = NESCSEQ;
		} else if (c == '\\') {
			esc = ESCSEQ;
		} else if (c == '/' && stack[spos] != DOUQUOT) {
			com = PCOMMEN;
		} else if (c == '\'') {
			if (stack[spos] == SINQUOT) {
				--spos;
			} else if (stack[spos] != DOUQUOT) {
				++spos;
				stack[spos] = SINQUOT;
				error[spos] = line;
			}
		} else if (c == '"') {
			if (stack[spos] == DOUQUOT) {
				--spos;
			} else if (stack[spos] != SINQUOT) {
				++spos;
				stack[spos] = DOUQUOT;
				error[spos] = line;
			}
		} else if (c == '(') {
			if (stack[spos] != SINQUOT && stack[spos] != DOUQUOT) {
				++spos;
				stack[spos] = PARENTH;
				error[spos] = line;
			}
		} else if (c == ')') {
			if (stack[spos] == SINQUOT || stack[spos] == DOUQUOT) {
				;
			} else if (stack[spos] == PARENTH) {
				--spos;
			} else {
				print_error(line, stack[spos]);
			}
		} else if (c == '{') {
			if (stack[spos] != SINQUOT && stack[spos] != DOUQUOT) {
				++spos;
				stack[spos] = BRACE;
				error[spos] = line;
			}
		} else if (c == '}') {
			if (stack[spos] == SINQUOT || stack[spos] == DOUQUOT) {
				;
			} else if (stack[spos] == BRACE) {
				--spos;
			} else {
				print_error(line, stack[spos]);
			}
		} else if (c == '[') {
			if (stack[spos] != SINQUOT && stack[spos] != DOUQUOT) {
				++spos;
				stack[spos] = BRACKET;
				error[spos] = line;
			}
		} else if (c == ']') {
			if (stack[spos] == SINQUOT || stack[spos] == DOUQUOT) {
				;
			} else if (stack[spos] == BRACKET) {
				--spos;
			} else {
				print_error(line, stack[spos]);
			}
		}

		
		/*
		if (c == '\n')
			printf("\\n %d:", spos);
		else if (c == '\t')
			printf("\\t %d:", spos);
		else
			printf("%c  %d:", c, spos);
		for (int i = 0; i <= spos; ++i)
			printf(" %d", stack[i]);
		putchar('\n');
		*/
		

		/*putchar(c);*/
		if (c == '\n')
			++line;
	}

	for (int i = 0; i <= spos; ++i)
		print_error(error[i], stack[i]);

	return 0;
}

/*
void check_char(int c, int const_c, int type)
{
	if (c == '\\' && (c2 = getchar()) == const_c) {
		;
	else if (c == const_c) {
		stack = OUT;
	}
	putchar(c);
	putchar(c2);
	c2 = '\0';
}
*/


void print_error(int line, int error)
{
	if (error == OUT)
		;
		/*printf("Error:l%d no matching character\n", line);*/
	else if (error == ICOMMEN)
		printf("Error:l%d unbalanced comments\n", line);
	else if (error == PARENTH)
		printf("Error:l%d unbalanced parentheses\n", line);
	else if (error == BRACE)
		printf("Error:l%d unbalanced braces\n", line);
	else if (error == BRACKET)
		printf("Error:l%d unbalanced brackets\n", line);
	else if (error == SINQUOT)
		printf("Error:l%d unbalanced single quotes\n", line);
	else if (error == DOUQUOT)
		printf("Error:l%d unbalanced double quotes\n", line);
}
