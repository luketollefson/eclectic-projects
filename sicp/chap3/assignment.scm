#lang sicp

(define balance 100)

(define (withdraw amount)
  (if (>= balance amount)
      (begin (set! balance (- balance amount))
             balance)
      "Insufficient funds"))

(define new-withdraw
  (let ((balance 100))
    (lambda (amount)
      (if (>= balance amount)
          (begin (set! balance (- balance amount))
                 balance)
          "Insufficient funds"))))

(define (make-withdraw balance)
  (lambda (amount)
    (if (>= balance amount)
        (begin (set! balance (- balance amount))
               balance)
        "Insufficient funds")))

(define (make-account balance)
  (define (withdraw amount)
    (if (>= balance amount)
        (begin (set! balance (- balance amount))
               balance)
        "Insufficient funds"))
  (define (deposit amount)
    (set! balance (+ balance amount))
    balance)
  (define (dispatch m)
    (cond ((eq? m 'withdraw) withdraw)
          ((eq? m 'deposit) deposit)
          (else (error "Unknown request -- MAKE-ACCOUNT"
                       m))))
  dispatch)

(define (make-accumulator sum)
  (lambda (x)
    (begin (set! sum (+ sum x))
           sum)))

(define (make-monitored f)
  (let ((calls 0))
    (lambda (m)
      (cond ((eq? m 'how-many-calls?) calls)
            ((eq? m 'reset-count) (set! calls 0))
            (else (set! calls (+ calls 1))
                  (f m))))))

(define (make-account balance password)
  (let ((pass-attempts 0))
    (define (withdraw amount)
      (if (>= balance amount)
          (begin (set! balance (- balance amount))
                 balance)
          "Insufficient funds"))
    (define (deposit amount)
      (set! balance (+ balance amount))
      balance)
    (define (call-the-cops)
      (error "Cops are coming, weewoo!"))
    (define (dispatch p m)
      (if (not (eq? password p))
          (if (> pass-attempts 7)
              (call-the-cops)
              (begin (set! pass-attempts (+ pass-attempts 1))
                     (error "Incorrect password " pass-attempts)))
          ((begin
             (set! pass-attempts 0)
             (cond ((eq? m 'withdraw) withdraw)
                   ((eq? m 'deposit) deposit)
                   (else (error "Unknown request -- MAKE-ACCOUNT"
                                m)))))))
    
    dispatch))

(define rand
  (let ((x random-init))
    (lambda ()
      (set! x (rand-update x))
      x)))

(define (estimate-pi trials)
  (sqrt (/ 6 (monte-carlo trials cesaro-test))))

(define (cesaro-test)
  (= (gcd (rand) (rand)) 1))

(define (monte-carlo trials experiment)
  (define (iter trials-remaining trials-passed)
    (cond ((= trials-remaining 0)
           (/ trials-passed trials))
          ((experiment)
           (iter (- trials-remaining 1) (+ trials-passed)))
          (else
           (iter (- trials-remaining 1) trials-passed))))
  (iter trials 0))
         
(define (estimate-pi trials)
  (sqrt (/ 6 (random-gcd-test trials random-init))))

(define (random-gcd-test trials initial-x)
  (define (iter trials-remaning trials-passed x)
    (let ((x1 (rand-update x)))
      (let ((x2 (rand-update x1)))
        (cond ((= trials-remaining 0)
               (/ trials-passed trials))
              ((= (gcd x1 x2) 1)
               (iter (- trials-remaining 1 )
                     (+ trials-passed 1)
                     x2))
              (else
               (iter (- trials-remaining 1)
                     trials-passed
                     x2))))))
  (iter trials 0 initial-x))

;; monte carlo simulation
(define (random-in-range low high))

(define (monte-carlo-integration trials P x1 x2 y1 y2)
  (let ((rect-area (* (x2 - x1) (y2 - y1)))
        (proportion (monte-carlo trials (P (random-in-range x1 x2)
                                           (random-in-range y1 y2)))))
    (* proportion rect-area)))

(define (rand symbol)
  (let ((x 0))
    (cond ((eq? symbol 'reset)
           (lambda (new-value) (rand-update new-value)))
          ((eq? symbol 'generate)
           (set! x (random-update x))
           x)
          (else (error "Bad symbol: " symbol)))))
               
         
         
                  
    
