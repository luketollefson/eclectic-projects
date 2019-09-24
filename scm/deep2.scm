(define length
  (lambda (l)
    (cond
      ((null? l) 0)
      (else (add1 (length (cdr l)))))))

;; Only works for empty list
(lambda (l)
  (cond
    ((null? l) 0)
    (else (add1 (eternity (cdr l))))))

;; Works for lists <= 2 in length
;; \l -> n
(lambda (l)
  (cond
    ((null? l) 0)
    (else (add1 ((lambda (l)
                   (cond
                     ((null? l) 0)
                     (else (add1 ((lambda (l)
                                    (cond
                                      ((null? l) 0)
                                      (else (add1 (eternity (cdr l)))))) (cdr l)))))) (cdr l))))))

;; Abstracting out the pattern
((lambda (length) ; \f -> l -> n
   (lambda (l) ; \l -> n
     (cond
       ((null? l) 0)
       (else (add1 (length (cdr l))))))) eternity) ; eternity is the "length" function

;; length<=1
((lambda (f) ; \f -> l -> n
   (lambda (l) ; \l -> n
     (cond
       ((null? l) 0)
       (else (add1 (f (cdr l)))))))
 ((lambda (g) ; \f -> l -> n
    (lambda (l) ; \l -> n
      (cond
        ((null? l) 0)
        (else (add1 (g (cdr l))))))) eternity))

;; length for lists <= 2
((lambda (length) ; \f -> l -> n
   (lambda (l) ; \l -> n
     (cond
       ((null? l) 0)
       (else (add1 (length (cdr l)))))))
 ((lambda (length) ; \f -> l -> n
    (lambda (l) ; \l -> n
      (cond
        ((null? 1) 0)
        (else (add1 (length (cdr 1)))))))
  ((lambda (length) ; \f -> l -> n
     (lambda (l) ; \l -> n
       (cond
         ((null? l) 0)
         (else (add1 (length (cdr l))))))) eternity)))

;; more abstraction
((lambda (mk-length) ; \f -> f -> l -> n
   (mk-length eternity))
 (lambda (length) ; \f -> l -> n
   (lambda (l) ; \l -> n
     (cond
       ((null? l) 0)
       (else (add1 (length (cdr l))))))))

;; for <= 2
((lambda (mk-length) ; \f -> f -> l -> n
   (mk-length
    (mk-length
     (mk-length eternity))))
 (lambda (length) ; \f -> l -> n
   (lambda (l) ; \l -> n
     (cond
       ((null? l) 0)
       (else (add1 (length (cdr l))))))))

;; still length0
((lambda (mk-length)
   (mk-length mk-length))
 (lambda (length) ; \f -> l -> n
   (lambda (l) ; \l -> n
     (cond
       ((null? l) 0)
       (else (add1 (length (cdr l))))))))

;; length <= 1
((lambda (mk-length)
   (mk-length mk-length))
 (lambda (mk-length)
   (lambda (l)
     (cond
       ((null? l) 0)
       (else (add1 ((mk-length eternity) (cdr l))))))))

;; horray we have length
((lambda (mk-length)
   (mk-length mk-length))
 (lambda (mk-length)
   (lambda (l)
     (cond
       ((null? l) 0)
       (else (add1 ((mk-length mk-length) (cdr l))))))))

;; extracting length
((lambda (mk-length)
   (mk-length mk-length))
 (lambda (mk-length)
   ((lambda (length)
      (lambda (l)
        (cond
          ((null? l) 0)
          (else (add1 (length (cdr l))))))) (mk-length mk-length))))

;; lets figure this out when l is (apples)
(((lambda (mk-length)
    (mk-length mk-length))
  (lambda (mk-length)
    ((lambda (length)
       (lambda (l)
         (cond
           ((null? l) 0)
           (else (add1 (length (cdr l))))))) (mk-length mk-length)))) l)

;; first we need the value of
((lambda (mk-length)
   (mk-length mk-length))
 (lambda (mk-length)
   ((lambda (length)
      (lambda (l)
        (cond
          ((null? l) 0)
          (else (add1 (length (cdr l))))))) (mk-length mk-length))))

;; but then we really need the value of
((lambda (mk-length)
   ((lambda (length)
      (lambda (l)
        (cond
          ((null? l) 0)
          (else (add1 (length (cdr l))))))) (mk-length mk-length)))
 (lambda (mk-length)
   ((lambda (length)
      (lambda (l)
        (cond
          ((null? l) 0)
          (else (add1 (length (cdr l))))))) (mk-length mk-length))))

;; but then we realllly need
((lambda (length)
   (lambda (l)
     (cond
       ((null? l) 0)
       (else (add1 (length (cdr l)))))))
 ((lambda (mk-length)
    ((lambda (length)
       (lambda (l)
         (cond
           ((null? l) 0)
           (else (add1 (length (cdr l))))))) (mk-length mk-length)))
  (lambda (mk-length)
    ((lambda (length)
       (lambda (l)
         (cond
           ((null? l) 0)
           (else (add1 (length (cdr l))))))) (mk-length mk-length)))))

;; mkin function right!!
((lambda (mk-length)
   (mk-length mk-length))
 (lambda (mk-length)
   (lambda (l)
     (cond
       ((null? l) 0)
       (else (add1 ((lambda (x) (mk-length mk-length) x)) (cdr l)))))))

;;
((lambda (mk-length)
   (mk-length mk-length))
 (lambda (mk-length)
   ((lambda (length)
      (lambda (l)
        (cond
          ((null? l) 0)
          (else (add1 (length (cdr l))))))) (lambda (x)
                                              ((mk-length mk-length) x)))))

;; new func length
((lambda (le)
   ((lambda (mk-length)
      (mk-length mk-length))
    (lambda (mk-length)
      (le (lambda (x) ((mk-length mk-length) x))))))
 (lambda (length)
   (lambda (l)
     (cond
       ((null? l) 0)
       (else (add1 (length (cdr l))))))))

;; sepearte func that makes length and one that looks like length
(lambda (le)
  ((lambda (mk-length)
     (mk-length mk-length))
   (lambda (mk-length)
     (le (lambda (x) ((mk-length mk-length) x))))))

;; OOOOO! AAAAH! The applicative-order Y combinator

(define Y
  (lambda (le)
    ((lambda (f) (f f))
     (lambda (f)
       (le (lambda (x) ((f f) x)))))))