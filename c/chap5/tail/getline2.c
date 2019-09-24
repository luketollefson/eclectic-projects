/* getline2: read a line into s, return length */
int getline2(char *s, int lim)
{
        char *s0 = s;

	for ( ; s<s0+lim-1 && (*s=getchar())!=EOF && *s!='\n'; s++)
		;
	if (*s == '\n')
		s++;
	*s = '\0';

	return s - s0;
}
