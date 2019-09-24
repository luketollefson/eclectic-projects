#include <ctype.h>
#include <string.h>
#include "getch.c"

#define MAXTOKEN 100

enum { NAME, PARENS, BRACKETS, ERROR };

int gettoken(void);
int tokentype;          /* type of last token */
char token[MAXTOKEN];   /* last token string */

int gettoken(void) /* return next token */
{
        int c, getch(void);
        void ungetch(int);
        char *p = token;

        while ((c = getch()) == ' ' || c == '\t')
                ;
        if (c == '(') {
                if ((c = getch()) == ')') {
                        strcpy(token, "()");
                        return tokentype = PARENS;
                } else {
                        ungetch(c);
                        return tokentype = '(';
                }
        } else if (c == '[') {
                for (*p++ = c; (*p++ = getch()) != ']' && *(p-1) != '\n'; )
                        ;
		if (*(p-1) == '\n')
			return tokentype == ERROR;
                *p = '\0';
                return tokentype = BRACKETS;
        } else if (isalpha(c)) {
                for (*p++ = c; isalnum(c = getch()); )
                        *p++ = c;
                *p = '\0';
                ungetch(c);
                return tokentype = NAME;
	} else if (c == ')')
		return tokentype = c;
	else
                return tokentype = c;
}
