(ns series)

(defn slices [string n]
  (if (> n 0)
    (->> (partition n 1 string)
         (filter seq)
         (mapv (partial clojure.string/join "")))
    [""]))


