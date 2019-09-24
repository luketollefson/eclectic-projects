static void swap(void *v[], int i, int j);

/* qsort2: sort v[left]...v[right] into increasing order */
void qsort2(void *v[], int left, int right,
	   int (*comp)(void *, void *))
{
        int i, last;

        if (left >= right)      /* do nothing if array contains */
                return;         /* fewer than two elements */
        swap(v, left, (left+right)/2);
        last = left;
        for (i = left+1; i <= right; i++)
                if ((*comp)(v[i], v[left]) < 0)
                        swap(v, ++last, i);
        swap(v, left, last);
        qsort2(v, left, last-1, comp);
        qsort2(v, last+1, right, comp);
}

/* swap: interchange v[i] and v[j] */
static void swap(void *v[], int i, int j)
{
        void *temp;

        temp = v[i];
        v[i] = v[j];
        v[j] = temp;
}
