#define KEYWORD  01
#define EXTERNAL 02
#define STATIC   04

/* or */
/* enum { KEYWORD = 01, EXTERNAL = 02, STATIC = 04 }; */

/* alt syntax using bit-fields */
struct {
	unsigned int is_keyword : 1;
	unsigned int is_extern  : 1;
	unsigned int is_static  : 1;
} flags;

/* natural man */
flags.is_extern = flags.is_static = 1; /* set bits on */
flags.is_extern = flags.is_static = 0; /* set bits off */
if (flags.is_extern == 0 && flags.is_static == 0) /* see if bits are off */
	...
