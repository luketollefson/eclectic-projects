#include <stdio.h>

void month_day(int year, int yearday, int *pmonth, int *pday);
int day_of_year(int year, int month, int day);
char *month_name(int n);

int main(void)
{
	printf("%d\n", day_of_year(2025, 2, 29));
	int month, day;
	month_day(2025, 366, &month, &day);
	printf("%d, %d\n", month, day);
	printf("%s\n", month_name(12));
	return 0;
}

/* month_name: return name of n-th month */
char *month_name(int n)
{
	static const char *name[] = {
		"Illegal month",
		"January", "February", "March",
		"April", "May", "June",
		"July", "August", "September",
		"October", "November", "December"
	};

	return (char *) ((n < 1 || n > 12) ? name[0] : name[n]);
}

static char daytab[2][13] = {
	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
	{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
};

/* day_of_year: set day of year from month & day */
int day_of_year(int year, int month, int day)
{
	int i, leap;

	leap = year%4 == 0 && year%100 != 0 || year%400 == 0;
	if (month > 12 || day > daytab[leap][month] || month < 1 || day < 1)
		return 0;
	for (i = 1; i < month; i++)
		day += daytab[leap][i];
	return day;
}

/* month_day: set month, day from day of year */
void month_day(int year, int yearday, int *pmonth, int *pday)
{
	int i, leap;

	leap = year%4 == 0 && year%100 != 0 || year %400 == 0;
	if (yearday > (leap ? 366 : 365)) {
		*pmonth = *pday = 0;
		return;
	}
	for (i = 1; yearday > daytab[leap][i]; i++)
		yearday -= daytab[leap][i];
	*pmonth = i;
	*pday = yearday;
}
