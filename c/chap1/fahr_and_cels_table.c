#include <stdio.h>

#define	LOWER	0	/* lower limit of table */
#define	UPPER	300	/* upper limit */
#define	STEP	20	/* step size */

/* print Fahrenheit-Celsius table using a seperate function */
float fahr_to_cels(float fahrenheit);

int main()
{
	int fahr;

	for (fahr = LOWER; fahr <= UPPER; fahr = fahr + STEP)
		printf("%3d %6.1f\n", fahr, fahr_to_cels(fahr));

	return 0;
}

float fahr_to_cels(float fahr)
{
	return (5.0/9.0)*(fahr-32);
}

/* print Fahrenheit-Celsius table reversed */
//int main()
//{
//	int fahr;
//
//	for (fahr = UPPER; fahr >= LOWER; fahr = fahr - STEP)
//		printf("%3d %6.1f\n", fahr, (5.0/9.0)*(fahr-32));
//
//	return 0;
//}

/* print Fahrenheit-Celsius table */

//int main()
//{
//	int fahr;
//
//	for (fahr = 0; fahr <= 300; fahr = fahr + 20)
//		printf("%3d %6.1f\n", fahr, (5.0/9.0)*(fahr-32));
//
//	return 0;
//}

/* print Fahrenheit-Celsius table
    for fahr = 0, 20, ..., 300; floating-point version */

//int main()
//{
//	float fahr, celsius;
//	int lower, upper, step;
//
//	lower = 0;	/* lower limit of temp table */
//	upper = 300;	/* upper limit */
//	step = 20;	/* step size */
//
//	fahr = lower;
//	while (fahr <= upper) {
//		celsius = (5.0/9.0) * (fahr-32.0);
//		printf("%3.0f %6.1f\n", fahr, celsius);
//		fahr = fahr + step;
//	}
//
//	return 0;
//}

/* print Fahrenheit-Celsius table
    for fahr = 0, 20, ..., 300 */

//int main()
//{
//	int fahr, celsius;
//	int lower, upper, step;
//
//	lower = 0;	/* lower limit of temp table */
//	upper = 300;	/* upper limit */
//	step = 20;	/* step size */
//
//	fahr = lower;
//	while (fahr <= upper) {
//		celsius = 5 * (fahr-32) / 9;
//		printf("%d\t%d\n", fahr, celsius);
//		fahr = fahr + step;
//	}
//
//	return 0;
//}
