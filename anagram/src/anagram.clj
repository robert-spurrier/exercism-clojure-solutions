(ns anagram
  (:require [clojure.set :as set]
            [clojure.string :refer [lower-case]]))

(defn anagram? [x y]
  (and
   (not= x y)
   (= (frequencies x) (frequencies  y))
   (empty? (set/difference (set x) (set y)))))

;; returns a lookup map containing original string casing
(defn normalize [coll]
  (zipmap (map lower-case coll) coll))

(defn anagrams-for [x coll]
  (let [n (normalize coll)]
    (->> (map lower-case coll)
         (filter (partial anagram? (lower-case x)))
         (mapv n))))
