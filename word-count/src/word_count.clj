(ns word-count
  (:require [clojure.string :refer [replace split blank? lower-case]]))

(defn word-count [x]
  (->> (split x #"\W")
       (map lower-case)
       (filter (comp not blank?))
       frequencies))



