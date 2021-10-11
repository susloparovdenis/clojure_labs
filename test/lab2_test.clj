(ns lab2_test
  (:require [clojure.test :refer :all]
            [same :refer [ish? zeroish?]]
            [lab2.lab2_1 :refer :all]
            )
  )

(defn pow4 [x] (reduce * (repeat 4 x)))
(defn pow3 [x] (reduce * (repeat 3 x)))

(defmacro get-time [expr]
  `(Float/parseFloat
     (second (re-find #": (.+) "
                      (with-out-str
                        (time ~expr))))))



(deftest integral-calculation
  (is (ish?
        (integral pow3 10)
        (/  (pow4 20) 4))))
        ;(* 10 (get-time (dotimes [_ 4] (memoized-integral pow4 1002)))))))

(deftest assert-memomized-faster-ten-times
  (is (<
        (get-time (dotimes [_ 4] (integral pow4 1002)))
        (* 10 (get-time (dotimes [_ 4] (memoized-integral pow4 1002)))))))

