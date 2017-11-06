(ns beer-song
  (:require [clojure.string :refer [join]]))

(defmulti beers (fn [x] x))

(defmethod beers 0 [x]
  "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")

(defmethod beers 1 [x]
  "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n")

(defmethod beers 2 [x]
  "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n")

(defmethod beers :default [x]
  (str x " bottles of beer on the wall, "
       x " bottles of beer.\nTake one down and pass it around, "
       (- x 1) " bottles of beer on the wall.
"))

(defn sing
  ([n]
   (sing n 0))   
  ([n x]
   (join "\n" (map beers (range n (- x 1) -1)))))

(defn verse [n]
  (beers n))
