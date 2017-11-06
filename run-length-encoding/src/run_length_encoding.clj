(ns run-length-encoding
  (:require [clojure.string :refer [join]]))

(defn encoder [y [k v]]
  (if (= v 1)
    (str y k)
    (str y v k)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (->> (partition-by identity s)
       (map (comp first frequencies))
       (reduce encoder "" )))

(defn coerce [x]
  (if (clojure.string/blank? x)
    " "
    (read-string x)))

(defn parser [s]
  (re-seq #"[0-9]+|[A-Z]|[a-z]|\W" s))

(defn blowout [n s]
  (join #"" (repeat (read-string (or n "1")) s)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (let [encoded-seq (parser s)]
    (loop [n nil
           result ""
           es encoded-seq]
      (if-let [next (first es)]
        (let [next-parsed (coerce next)]
          (if (integer? next-parsed)
            (recur (str n next) result (rest es))
            (recur nil (str result (blowout n next)) (rest es))))
        result))))





