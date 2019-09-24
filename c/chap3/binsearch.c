#include <stdio.h>

int binsearch(int x, int v[], int n);
int binsearch2(int x, int v[], int n);

int main()
{
	int v[30];
	for (int i = 0; i < 30; ++i)
		v[i] = 2 * i;

	printf("%d\n", binsearch(10, v, 30));

	printf("%d\n", binsearch2(10, v, 30));

	return 0;
}

/* binsearch2; find x in v[0] <= v[1] <= ... <= v[n-1] */
/* this version uses less tests within the loop */
int binsearch2(int x, int v[], int n)
{
	int low, high, mid;

	low = 0;
	high = n - 1;
	while (low <= high) {
		mid = (low+high) / 2;
		if (x < v[mid])
			high = mid - 1;
		else
			low = mid + 1;
	}

	if (x == v[low])
		return low;
	else if (x == v[high])
		return high;
	else
		return -1;
}

/* binsearch: find x in v[0] <= v[1] <= ... <= v[n-1] */
int binsearch(int x, int v[], int n)
{
	int low, high, mid;

	low = 0;
	high = n - 1;
	while (low <= high) {
		mid = (low+high) / 2;
		if (x < v[mid])
			high = mid - 1;
		else if (x > v[mid])
			low = mid + 1;
		else /* found match */
			return mid;
	}
	return -1; /* no match */
}
