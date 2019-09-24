void swap(int *px, int *py);

int main(void)
{
	int i = 3;
	int j = 5;

	swap(&i, &j);

	return 0;
}

void swap(int *px, int *py) /* interchange *px and *py */
{
	int temp;

	temp = *px;
	*px = *py;
	*py = temp;
}
