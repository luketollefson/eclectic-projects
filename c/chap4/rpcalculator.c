#include <stdio.h>
#include <stdlib.h>	/* for atof() */
#include <math.h>

#define	MAXOP	100	/* max size of operand or operator */
#define NUMBER	'0'	/* signal that a number was found */
#define VAR	'A'	/* signal that a var was found */

int getop(char []);
void init_getop(void);
void push(double);
void push_var(char);
double pop(void);
char pop_var(void);
void set_var(char var, double val);
double recent_Z(double x);
double top(void);
void clear_stack(void);

/* reverse Poslish calculator */
/* compile with gcc rpcalculator.c -lm getline2.c */
int main()
{
	int type;
	double op2, op3;
	char s[MAXOP];
	
	init_getop();

	while ((type = getop(s)) != EOF) {
		switch (type) {
		case NUMBER:
			push(atof(s));
			break;
		case VAR:
			push_var(s[0]);
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
		case '%':
			op2 = pop();
			if (op2 != 0.0)
				push((int) pop() % (int) op2);
			else
				printf("error: zero divisor\n");
			break;
		case '^':
			op2 = pop();
			push(pow(pop(), op2));
			break;
		case 's':
			push(sin(pop()));
			break;
		case 'c':
			push(cos(pop()));
			break;
		case 'e':
			push(exp(pop()));
			break;
		case '=':
			op2 = pop();
			s[0] = pop_var();
			set_var(s[0], op2);
			push_var(s[0]);
			break;
		case 't':	/* print the top element of the stack without poping it */
			printf("\t%.8g\n", recent_Z(top()));
			break;
		case 'd':	/* duplicate the top element of the stack */
			push(top());
			break;
		case 'f':	/* flip the top two elements */
			op2 = pop();
			op3 = pop();
			push(op2);
			push(op3);
			break;	
		case 'v':
			clear_stack();
			break;
		case '\n':
			printf("\t%.8g\n", recent_Z(pop()));
			init_getop();
			break;
		default:
			printf("error: unknown command %s\n", s);
			break;
		}
	}
	return 0;
}

#define MAXVAL	100	/* maximum depth of val stack */

int sp = 0;		/* next free stack position */
double val[MAXVAL];	/* value stack */
char var[MAXVAL]; 	/* array type, either NUMBER or char A-Z */

/* push: push f onto value stack */
void push(double f)
{
	if (sp < MAXVAL) {
		var[sp] = NUMBER;
		val[sp++] = f;
	} else
		printf("error: stack full, can't push %g\n", f);
}

/* pop: pop and return top value from stack */
double pop(void)
{
	if (sp > 0)
		return val[--sp];
	else {
		printf("error: stack empty\n");
		return 0.0;
	}
}

double varval[25];	/* value of every variable A-Z */

/* push_var: push variable onto value stack and varaible stack*/
void push_var(char variable)
{
	if (sp < MAXVAL) {
		var[sp] = variable;
		val[sp++] = varval[variable - 'A'];
	} else
		printf("error: stack full, can't push %c\n", variable);
}

/* pop_var: pop variable */
char pop_var(void)
{
	if (sp > 0)
		return var[--sp];
	else {
		printf("error: stack empty\n");
		return VAR;
	}
}

/* set_var: set variable */
void set_var(char variable, double val)
{
	varval[variable - 'A'] = val;
}

/* top: return the top element of the stack */
double top(void)
{
	if (sp > 0)
		return val[sp-1];
	else {
		printf("error: stack empty\n");
		return 0.0;
	}
}

/* recent_Z: sets Z to x and returns x */
double recent_Z(double x)
{
	varval[25] = x;
	return x;
}

/* clear_stack: clear the stack */
void clear_stack(void)
{
	sp = 0;
}

#include <ctype.h>

#define MAXLINE	1000

int getline2(char [], int);

char line[MAXLINE];
int pos;
int last_char;

void init_getop(void)
{
	last_char = getline2(line, MAXLINE);
	pos = 0;
}

int getop(char s[])
{
	int i = 0;

	if (last_char == EOF)
		return EOF;

	while (line[pos] == ' ' || line[pos] == '\t')
		pos++;	
	if (isupper(line[pos])) {
		s[i] = line[pos++], s[++i] = '\0';
		return VAR;
	}	
	if (!isdigit(line[pos]) && line[pos] != '.' && line[pos] != '-') {
		s[i] = line[pos];
		pos++;
		s[i+1] = '\0';
		return s[i];
	}
	if (line[pos] == '-') {
		if (isdigit(line[pos+1])) {
			s[i++] = '-';
			pos++;
		} else {
			pos++;
			return '-';
		}
	}
	while (isdigit(line[pos])) {
		s[i] = line[pos];
		i++;
		pos++;
	}
	if (line[pos] == '.') {
		s[i++] = '.';
		pos++;
		while (isdigit(line[pos])) {
			s[i++] = line[pos];
			pos++;
		}
	}
	s[i] = '\0';
	return NUMBER;
}


//int getch(void);
//void ungetch(int);
//void ungets(char []);
//
///* getop: get next operator or numeric operand */
//int getop(char s[])
//{
//	int i, c;
//
//	while ((s[0] = c = getch()) == ' ' || c == '\t')
//		;
//	s[1] = '\0';
//	if (isupper(c)) {
//		s[0] = c;
//		return VAR;
//	}
//	if (!isdigit(c) && c != '.' && c != '-')
//		return c;	/* not a number */
//	i = 0;
//	if (c == '-')
//		if (isdigit(s[++i] = c = getch()))
//			s[0] = '-';
//		else {
//			ungetch(c);
//			return '-';
//		}
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

//int buf = '\0'; /* buffer character */
//
//int getch(void) /* get a (possibly pushed back) character */
//{
//	char buf2;
//	if (buf == '\0')
//		return getchar();
//	else {
//		buf2 = buf;
//		buf = '\0';
//		return buf2;
//	}
//}
//
//void ungetch(int c) /* push character back on input */
//{
//	buf = c;
//}

#define BUFSIZE	100

//int buf[BUFSIZE];	/* buffer for ungetch */
int bufp = 0;		/* next free position in buf */

/*
int getch(void) 
{
	return (bufp > 0) ? buf[--bufp] : getchar();
}

void ungetch(int c)
{
	if (bufp >= BUFSIZE)
		printf("ungetch: too many characters\n");
	else
		buf[bufp++] = c;
}
*/

#include <string.h>

//void ungets(char s[]) /* push string back on input */
//{
//	int i;
//	for (i = strlen(s); i >= 0; i--)
//		ungetch(s[i]);
//}
