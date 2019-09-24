#include <stdio.h>

#define	MAXLINE 1000	/* maximum processable line */
#define	MAXLEN	20	/* maximum column width */
#define	TABSTOP	8	/* tabstop width */
#define	BLANK	0	/* inside a blank */
#define WORD	1	/* inside a word */
 
void print_range(char s[], int start, int end);
int get_line(char s[], int lim);
void put_line(char s[], int maxline);

int llength;

/* fold2.c: word wraps long lines */
int main()
{
	extern int llength;
	char line[MAXLINE];

	while ((llength = get_line(line, MAXLINE)) > 0)
		put_line(line, MAXLEN);

	return 0;
}

/* put_line: puts a word wrapped line */
void put_line(char s[], int maxline)
{
	// the blanks will always be before the word except at end
	int spos, lpos, blength, bwidth, wlength, state;

	lpos = 0;
	blength = 0;
	bwidth = 0;
	wlength = 0;
	state = BLANK;
	for (spos = 0; s[spos] != '\0' && s[spos] != '\n'; ++spos)
		if ((s[spos] == ' ' || s[spos] == '\t') && state == WORD) {
			state = BLANK;
			if (lpos + bwidth + wlength <= maxline) {
				print_range(s, spos - wlength - blength, spos - 1);
				lpos += bwidth + wlength;
			} else if (wlength > maxline) {
				int i;
				for (i = spos - wlength; i < spos; ++i)
					if ((i-(spos-wlength)) % maxline == 0) {
						putchar('\n');
						putchar(s[i]);
					} else
						putchar(s[i]);
				lpos = (i-(spos-wlength)) % maxline;
			} else {
				putchar('\n');
				print_range(s, spos - wlength, spos - 1);
				lpos = wlength;
			}
			wlength = 0;
				blength = 1;
			if (s[spos] == '\t')
				bwidth = 8 - lpos % TABSTOP;
			else
				bwidth = 1;
		} else if ((s[spos] == ' ' || s[spos] == '\t') && state == BLANK) {
			++blength;
			if (s[spos] == '\t')
				bwidth += 8 - lpos % TABSTOP;
			else
				++bwidth;
		} else if (state == BLANK) {
			state = WORD;
			wlength = 1;
		} else if (state == WORD)
			++wlength;

	if (lpos + bwidth + wlength <= maxline) {
		print_range(s, spos - wlength - blength, spos - 1);
		lpos += bwidth + wlength;
	} else if (wlength > maxline) {
		int i;
		for (i = spos - wlength; i < spos; ++i)
			if (i-(spos-wlength) == 0 && lpos != 0 || (i-(spos-wlength)) !=0 && (i-(spos-wlength)) % maxline == 0) {
				putchar('\n');
				putchar(s[i]);
			} else
				putchar(s[i]);
		lpos = (i-(spos-wlength)) % maxline;
	} else {
		putchar('\n');
		print_range(s, spos - wlength, spos - 1);
		lpos = wlength;
	}
	putchar(s[spos]);
}

/* print_range: print a range of characters in char array, value is index*/
void print_range(char s[], int start, int end)
{
	extern int llength;
	if (start <= end && end < llength)
		for (int i = start; i <= end; ++i)
			putchar(s[i]);
}

/* get_line: read a line into s, return length */
int get_line(char s[], int lim)
{
	int c, pos;
	for (pos=0; pos<lim-1 && (c=getchar())!=EOF && c!='\n'; ++pos)
		s[pos] = c;
	if (c == '\n') {
		s[pos] = c;
		++pos;
	}
	s[pos] = '\0';
	return pos;
}
