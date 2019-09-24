#include <stdio.h>
#include <string.h>
#include <ctype.h>

void dcl(void);
void dirdcl(void);

#include "gettoken.c"
//enum { NAME, PARENS, BRACKETS };
extern int gettoken(void);
extern int tokentype;		/* type of last token */
extern char token[MAXTOKEN];	/* last token string */
char name[MAXTOKEN];	/* identifier name */
char datatype[MAXTOKEN];/* data type = char, int, etc. */
char out[1000];

int main(void)	/* convert declaration to words */
{
	while (gettoken() != EOF) {	/* 1st token on line */
		strcpy(datatype, token);/* is the datatype */
		out[0] = '\0';
		if (tokentype != '\n')
			dcl();	/* parse rest of line */
		if (tokentype != '\n')
			if (tokentype == '(')
				printf("error: missing )\n");
			else
				printf("syntax error\n");
		if (*name && tokentype == '\n')
			printf("%s: %s %s\n", name, out, datatype);
		name[0] = '\0';
	}
	return 0;
}

/* dcl: parse a declarator */
void dcl(void)
{
	int ns;

	if (tokentype == ERROR)
		return;
	for (ns = 0; gettoken() == '*'; )  /* count *'s */
		ns++;
	dirdcl();
	while (ns-- > 0)
		strcat(out, " pointer to");
}

/* dirdcl: parse a direct declarator */
void dirdcl(void)
{
	int type;

	if (tokentype == ERROR)
		return;

	if (tokentype == '(') {		/* ( dcl ) */
		dcl();
		if (tokentype != ')') {
			printf("error: missing )\n");
			tokentype = ERROR;
			return;
		}
	} else if (tokentype == NAME)	/* variable name */
		strcpy(name, token);
	else {
		printf("error: expected name or (dcl)\n");
		tokentype = ERROR;
		return;
	}
	while ((type=gettoken()) == PARENS || type == BRACKETS)
		if (type == PARENS)
			strcat(out, " function returning");
		else {
			strcat(out, " array");
			strcat(out, token);
			strcat(out, " of");
		}
}
