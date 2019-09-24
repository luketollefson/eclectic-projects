(println "Hello, world!") ; Say hi.


(defn say-welcome [what]
  (println "Welcome to" what))

;; define the average function
(defn average [a b]
  (/ (+ a b) 2.0))

(average 5.0 10.0)

(defn chatty-average [a b]
  (println "chatty-average function called")
  (println "** first argument:" a)
  (println "** second argument:" b)
  (/ (+ a b) 2.0))
