(ns collatz-conjecture)

(defn collatz
  ([n] (collatz n 0))
  ([n x]
   (cond
    (<= n 0) (throw (IllegalArgumentException.))
    (= 1 n) x
    (even? n) (collatz (/ n 2) (inc x))
    (odd? n) (collatz (inc (* 3 n)) (inc x)))))

