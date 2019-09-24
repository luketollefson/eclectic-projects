#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printd(int n);
unsigned long recurs(unsigned long);
void qsort2(int v[], int left, int right);
//void itoa(int n, char s[]);
int itoa(int n, char s[]);
void reverse(char s[], int first, int last);

int main(void)
{
	printd(-1234);
	printf("\n");

	/*
	int v[1000];
	for (int i = 0; i < 1000; i++)
		v[i] = rand();

	qsort2(v, 0, 999);

	for (int i = 0; i < 1000; i++)
		printf("%d\n", v[i]);
	*/
	char s[100];
	int k;
	k = itoa(48291, s);
	printf("%s %d\n", s, k);
	k = itoa(48248291, s);
	printf("%s %d\n", s, k);
	k = itoa(-48291, s);
	printf("%s %d\n", s, k);

	char hello[] = "hello world!";
	reverse(hello, 0, strlen(hello)-1);
	printf("%s\n", hello);
	return 0;
}


/* reverse: reverse string from s[first]...s[last] */
void reverse(char s[], int first, int last)
{
	void swapc(char [], int, int);

	if (first <= last) {
		swapc(s, first, last);
		reverse(s, first+1, last-1);
	}
}

/* swapc: interchange s[i] and s[j] */
void swapc(char s[], int i, int j)
{
	char temp;

	temp = s[i];
	s[i] = s[j];
	s[j] = temp;
}

/* itoa: convert n to a string s recursivly */
int itoa(int n, char s[])
{
	int i = 0;

	if (n / 10)
		i += itoa(n / 10, s);

	if (n < 0) {
		s[0] = '-';
		s[i+1] = -n % 10 + '0';
		s[i+2] = '\0';
	} else {
		s[i] = n % 10 + '0';
		s[i+1] = '\0';
	}

	return ++i;
}


/* itoa: convert n to a string s recursivly
 * this version only works on positive numbers
 */
/*
int itoa(int n, char s[])
{
	int i = 0;

	if (n / 10)
		i += itoa(n / 10, s);

	s[i] = n % 10 + '0';
	s[i+1] = '\0';

	return ++i;
}
*/

/* recurs: see how deep recursion can get (around 261820 before seg fault, but far higher with optomization) */
unsigned long recurs(unsigned long i)
{
	printf("%lu\n", ++i);
	return recurs(i);
}

/* qsort2: sort v[left]...v[right] into increasing order */
void qsort2(int v[], int left, int right)
{
	int i, last;
	void swap(int v[], int i, int j);

	if (left >= right)	/* do nothing if array contains */
		return;		/* fewer than two elements */
	swap(v, left, (left + right)/2);	/* move partition elem */
	last = left;				/* to v[0] */
	for (i = left+1; i <= right; i++)	/* partition */
		if (v[i] < v[left])
			swap(v, ++last, i);
	swap(v, left, last);		/* restore partition elem */
	qsort2(v, left, last-1);
	qsort2(v, last+1, right);
}

/* swap: interchange v[i] and v[j] */
void swap(int v[], int i, int j)
{
	int temp;

	temp = v[i];
	v[i] = v[j];
	v[j] = temp;
}

/* printd: print n in decimal */
void printd(int n)
{
	if (n < 0) {
		putchar('-');
		n = -n;
	}
	if (n / 10)
		printd(n / 10);
	putchar(n % 10 + '0');
}


