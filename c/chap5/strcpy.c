/* strcpya: copy t to s; array subscript version */
void strcpy(char *s, char *t)
{
	int i;

	i = 0;
	while ((s[i] = t[i]) != '\0')
		i++;
}

/* strcpyp1: copy t to s; pointer version 1 */
void strcpyp1(char *s, char *t)
{
	while ((*s = *t) != '\0') {
		s++;
		t++;
	}
}

/* strcpy2: copy t to s; pointer version 2 */
void strcpy2(char *s, char *t)
{
	while ((*s++ = *t++) != '\0')
		;
}

/* strcpy2: copy t to s; pointer version 2 */
void strcpy2(char *s, char *t)
{
	while (*s++ = *t++)
		;
}
