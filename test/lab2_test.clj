(ns lab2_test
  (:require [clojure.test :refer :all]
            [lab2 :refer :all]))

(defn pow4 [x] (reduce * (repeat 4 x)))



(memoized-integral pow4 10000)
(deftest pow4-test
  (is (= (pow4 2)
         16)))

(time (mem))
(deftest time-comp
  
  (is (= (pow4 2)
         16)))

