(ns phone-number)

(defn scrub [x]
  (clojure.string/replace x #"\W" ""))

(defn valid? [x]
  (cond
    (and (not= \1 (first x))
         (= 11 (count x))) false
    (< (count x) 10) false
    (> (count x) 11) false
    :default true))
          
(defn area-code [x]
  (let [x (scrub x)]
    (if (= (count x) 11)
     (subs x 1 4)
     (subs x 0 3))))

(defn number [x]
  (let [number (scrub x)]
    (if-not (valid? number)
      "0000000000"
      (if (= (count number) 11)
        (subs number 1)
        number))))

(defn pretty-print [x]
  (let [n (scrub x)]
    (if (= (count n) 10)
      (str "(" (subs n 0 3) ") " (subs n 3 6) "-" (subs n 6 10))
      (str "(" (subs n 1 4) ") " (subs n 4 7) "-" (subs n 7 11)))))








