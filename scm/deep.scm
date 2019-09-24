(define eternity
  (lambda (x)
    (eternity x)))

;; length used define
(define length
  (lambda (l)
    (cond
      ((null? l) 0)
      (else (add1 (length (cdr l)))))))

;; we could call it length0
;; \l -> n
;; This function only determines the length of the empty list
;; It doesn't do much on anything else!
(lambda (l)
  (cond
    ((null? l) 0)
    (else (add1 (eternity (cdr l))))))

;; we could call this length<=1
;; \l -> n
(lambda (l)
  (cond
    ((null? l) 0)
    (else (add1 ((lambda (l)
	           (cond
	    	     ((null? l) 0)
  	             (else (add1 eternity (cdr l)))))) (cdr l))))))
