(ns hamming)

(defn distance [x y]
  (when (= (count x) (count y))
   (->>
    (map #(if (= %1 %2) 0 1) x y)
    (reduce +))))
