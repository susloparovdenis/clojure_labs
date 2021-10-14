(ns lab2.common
  (:use infix.macros))

(def default_step (/ 1 40))

(defn t-area [h a b]
  ($= (a + b) * h / 2.0))
