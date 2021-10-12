(ns lab2_test
  (:use clojure.algo.generic.math-functions)
  (:require [clojure.test :refer :all]
            [clojure.algo.generic :refer :all]
            [lab2.lab2_1 :refer :all]))

(defmacro get-time [expr]
  `(Float/parseFloat
    (second (re-find #": (.+) "
                     (with-out-str
                       (time ~expr))))))

(defn pow4 [x] (reduce * (repeat 4 x)))
(defn pow3 [x] (reduce * (repeat 3 x)))

(deftest integral-calculation
  (is (approx=
       (let [integral (create_integral_fn (/ 1 30) pow3)] (integral 4))
       (/ (pow4 4) 4)
       1e-2)))

(deftest assert-memoized-faster-ten-times
  (is (<
       (let [f (create_integral_fn (/ 1 30) pow4)]
         (* 10 (get-time (dotimes [i 40] (f i)))))

       (get-time (dotimes [i 40] (integral-tail pow4 i))))))
