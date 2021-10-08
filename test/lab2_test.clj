(ns lab2_test
  (:require [clojure.test :refer :all]
            [lab2.lab2_1 :refer :all]))

(defn pow4 [x] (reduce * (repeat 4 x)))

(defmacro get-time [expr]
  `(Float/parseFloat
     (second (re-find #": (.+) "
                      (with-out-str
                        (time ~expr))))))

"" (deftest assert-memomized-faster-ten-timesa
  (is (>
        (get-time (dotimes [_ 4] (integral pow4 1002)))
        (* 10 (get-time (dotimes [_ 4] (memoized-integral pow4 1002)))))))

(deftest time-comp
  (is (= (pow4 2)
         16)))
