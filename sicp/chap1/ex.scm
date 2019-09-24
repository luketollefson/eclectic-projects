;; exercise 1.3
(define (square x) (* x x))

(define (sum-squares x y z)
  (cond ((< x y z) (+ (square y) (square z)))
	((< y x z) (+ (square x) (square z)))
	(else (+ (square x) (square y)))))

;; exercise 1.4
(define (a-plus-abs-b a b)
  ((if (> b 0) + -) a b))

;; exercise 1.5
(define (p) (p))

(define (test x y)
  (if (= x 0)
      0
      y))

;; exercise 1.6
(define (new-if predicate then-clause else-clause)
  (cond (predicate then-clause)
	(else else-clause)))

;; example 1.1.7
(define (sqrt x)
  (sqrt-iter 1.0 x))

(define (sqrt-iter guess x)
  (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x) x)))

(define (improve guess x)
  (average guess (/ x guess)))

(define (average x y)
  (/ (+ x y) 2))

;; (define (good-enough? guess x)
;;   (< (abs (- (square guess) x)) 0.001))

;; (define (sqrt-iter guess x)
;;   (new-if (good-enough? guess x)
;; 	  guess
;; 	  (sqrt-iter (improve guess x)
;; 		     x)))

(define (good-enough? guess x)
  (< (abs (- 1.0 (/ (square guess) x))) 0.001))

;; exercise 1.8
(define (cube-root x)
  (cube-root-iter 1.0 x))

(define (cube-root-iter guess x)
  (if (cube-good-enough? guess x)
      guess
      (cube-root-iter (cube-improve guess x) x)))

(define (cube-improve guess x)
  (/ (+ (/ x (square guess))
	(* 2 guess))
     3))

(define (cube-good-enough? guess x)
  (< (abs (- 1.0 (/ (* guess guess guess) x))) 0.001))

;; exercise 1.9
;; first is recursive process
;; second is iterave process

;; exercise 1.10
(define (A x y)
  (cond ((= y 0) x)
	((= x 0) (* 2 y))
	((= y 1) 2)
	(else (A (- x 1)
		 (A x (- y 1))))))

;; simplyies to 2n
(define (f n) (A 0 n))

;; simplify 2^n
(define (g n) (A 1 n))

;; simplify ??
(define (h n) (A 2 n))

;; simplify to 5n^2
(define (k n) (* 5 n n))

;; exercise 1.11
(define (f n)
  (if (< n 3)
      n
      (+ (f (- n 1))
	 (* 2 (f (- n 2)))
	 (* 3 (f (- n 3))))))

(define (f2 n)
  (define (f2-iter a b c count)
    (if (= count 0)
	c
	(f2-iter (+ a (* 2 b) (* 3 c)) a b (- count 1))))
  (f2-iter 2 1 0 n))

;; exercise 1.12
;; compute an element of Pascal's triangle
(define (pascal row col)
  (cond ((= col 1) 1)
	((= col row) 1)
	(else (+ (pascal (- row 1) (- col 1))
		 (pascal (- row 1) col)))))

;; exercise 1.14
;; space increases O(n)
;; steps increases O(n^2)

;; exercise 1.15
(define (cube x) (* x x x))

(define (p x) (- (* 3 x) (* 4 (cube x))))

(define (sine angle)
  (if (not (> (abs angle) 0.1))
      angle
      (p (sine (/ angle 3.0)))))

;; exercise 1.20
