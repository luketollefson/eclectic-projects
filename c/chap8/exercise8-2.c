#include <unistd.h>

#undef NULL
#define NULL	0
#define EOF	(-1)
#define BUFSIZ	1024
#define OPEN_MAX 20	/* max #files open at once */

typedef struct _ioflags {
	unsigned int is_read	: 1;	/* file open for reading */
	unsigned int is_write	: 1;	/* file open for writing */
	unsigned int is_unbuf	: 1;	/* file is unbuffered */
	unsigned int is_eof	: 1;	/* EOF has occurred on this file */
	unsigned int is_error	: 1;	/* error occurred on this file */
} Flags;

typedef struct _iobuf {
	int cnt;	/* characters left */
	char *ptr;	/* next character position */
	char *base;	/* location of buffer */
	Flags flags;	/* mode of file access */
	int fd;		/* file descriptor */
} FILE2;

FILE2 _iob[OPEN_MAX] = {	/* stdin2, stdout2, stderr2: */
	{ 0, (char *) 0, (char *) 0, {1, 0, 0, 0, 0}, 0 },
	{ 0, (char *) 0, (char *) 0, {0, 1, 0, 0, 0}, 1 },
	{ 0, (char *) 0, (char *) 0, {0, 1, 1, 0, 0}, 2 }
};

#define stdin2	(&_iob[0])
#define stdout2	(&_iob[1])
#define stderr2	(&_iob[2])


int _fillbuf(FILE2 *);
int _flushbuf(int, FILE2 *);

#undef feof2
#define feof2(p)		((p)->flags.is_eof == 1)
#define ferror2(p)	((p)->flags.is_error == 1)
#define fileno2(p)	((p)->fd)

#define getc2(p)	(--(p)->cnt >= 0 \
		? (unsigned char) *(p)->ptr++ : _fillbuf(p))
#define putc2(x,p)	(--(p)->cnt >= 0 \
			? *(p)->ptr++ = (x) : _flushbuf((x),p))

#define getchar2()	getc2(stdin2)
#define putchar2(x)	putc2((x), stdout2)

#include <stdlib.h>

/* _fillbuf: allocate and fill input buffer */
int _fillbuf(FILE2 *fp)
{
	int bufsize;

	if (!fp->flags.is_read || fp->flags.is_eof || fp->flags.is_error)
		return EOF;
	bufsize = (fp->flags.is_unbuf) ? 1 : BUFSIZ;
	if (fp->base == NULL)		/* no buffer yet */
		if ((fp->base = (char *) malloc(bufsize)) == NULL)
			return EOF;	/* cant get buffer */
	fp->ptr = fp->base;
	fp->cnt = read(fp->fd, fp->ptr, bufsize);
	if (--fp->cnt < 0) {
		if (fp->cnt == -1)
			fp->flags.is_eof = 1;
		else
			fp->flags.is_error = 1;
		fp->cnt = 0;
		return EOF;
	}
	return (unsigned char) *fp->ptr++;
}

/* _flushbuf: clear buffer and fill in with x */
int _flushbuf(int x, FILE2 *fp)
{
	int bufsize;

	if (!fp->flags.is_write
}

#include <fcntl.h>
#define PERMS 0666	/* RW for owner, group, others */

/* fopen2: open file, return file ptr */
FILE2 *fopen2(char *name, char *mode)
{
	int fd;
	FILE2 *fp;

	if (*mode != 'r' && *mode != 'w' && *mode != 'a')
		return NULL;
	for (fp = _iob; fp < _iob + OPEN_MAX; fp++)
		if (!fp->flags.is_read && !fp->flags.is_write)
			break;	/* found free slot */
	if (fp >= _iob + OPEN_MAX)	/* no free slots */
		return NULL;

	if (*mode == 'w')
		fd = creat(name, PERMS);
	else if (*mode == 'a') {
		if ((fd = open(name, O_WRONLY, 0)) == -1)
			fd = creat(name, PERMS);
		lseek(fd, 0L, 2);
	} else
		fd = open(name, O_RDONLY, 0);
	if (fd == -1)	/* couldn't access name */
		return NULL;
	fp->fd = fd;
	fp->cnt = 0;
	fp->base = NULL;
	if (*mode == 'r')
		fp->flags.is_read = 1;
	else
		fp->flags.is_write = 1;
	return fp;
}

#include <stdio.h>
int main(void)
{
	int fd;
	FILE2 *fp;
	fp = fopen2("rand2.txt", "r");
	int c;
	while ((c = getc2(fp)) != EOF)
		putchar(c);
	printf("%d\n", fp->cnt);
	return 0;
}
