#include <stdio.h>

void shellsort(int v[], int n);

int main()
{
	int v[100];
	for (int i = 0; i < 100; i++)
		v[i] = 100 - i;

	shellsort(v, 100);
	for (int i = 0; i < 100; i++)
		printf("%d ", v[i]);

	putchar('\n');

	return 0;
}

/* shellsort: sort v[0]...v[n-1] into increasing order */
void shellsort(int v[], int n)
{
	int gap, i, j, temp;

	for (gap = n/2; gap > 0; gap /= 2)
		for (i = gap; i < n; i++)
			for (j=i-gap; j>=0 && v[j]>v[j+gap]; j-=gap) {
				temp = v[j];
				v[j] = v[j+gap];
				v[j+gap] = temp;
			}
}	
