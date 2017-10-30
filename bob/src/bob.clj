(ns bob
  (:require [clojure.string :refer [upper-case blank?]]))

;; Sure. = ends in question mark unless all caps
(defn question? [x]
  (= \? (last x)))
;; Whoa, chill out! = chracters all caps, can have symbols. 
(defn yelling? [x]
  (and (some #(Character/isUpperCase %) x)
       (= x (upper-case x))))
;; Fine. Be that way! = whitespace, empty string
(defn silence? [x]
  (blank? x))
;; Whatever. = anything else)
(defn response-for [x]
  (cond
    (yelling? x) "Whoa, chill out!"
    (question? x) "Sure."
    (silence? x) "Fine. Be that way!"
    :else "Whatever."))




