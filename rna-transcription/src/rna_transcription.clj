(ns rna-transcription
  (:require [clojure.string :refer [join]]))

(defn dna? [x]
  (every? #{\A \T \C \G} x))

(defn to-rna [x]
  {:pre [(dna? x)]}
  (let [pair {\A "U"
              \T "A"
              \C "G"
              \G "C"}]
    (join (map #(get pair %) x))))


