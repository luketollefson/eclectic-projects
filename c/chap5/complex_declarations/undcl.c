#include <stdio.h>
#include <string.h>

#define MAXTOKEN 100

#include "gettoken.c"
//enum { NAME, PARENS, BRACKETS };
extern int gettoken(void);
extern int tokentype;          /* type of last token */
extern char token[MAXTOKEN];   /* last token string */
char out[1000];

/* undcl: convert word description to declaration */
int main(void)
{
	int type;
	int last_type = 0;
	int next_type = 0;
	char temp[MAXTOKEN];
	char cur_token[MAXTOKEN];

	while ((type = gettoken()) != EOF) {
		strcpy(cur_token, token);
//		strcpy(out, cur_token);
		while (type != '\n') {
			if (next_type != '\n')
				next_type = gettoken();
			if (type == PARENS || type == BRACKETS)
				strcat(out, cur_token);
			else if (type == '*') {
				if (last_type == '*' || next_type == NAME || !last_type)
					sprintf(temp, "*%s", out);
				else
					sprintf(temp, "(*%s)", out);
				strcpy(out, temp);
			} else if (type == NAME) {
				if (out[0] != '\0')
					sprintf(temp, "%s %s", cur_token, out);
				else
					sprintf(temp, "%s", cur_token);
				strcpy(out, temp);
			} else
				printf("invalid input at %s\n", cur_token);
			strcpy(cur_token, token);
			last_type = type;
			type = next_type;
		}
		printf("%s\n", out);
		type = 0;
		last_type = 0;
		next_type = 0;
		token[0] = '\0';
		out[0] = '\0';
		temp[0] = '\0';
	}
	return 0;
}
