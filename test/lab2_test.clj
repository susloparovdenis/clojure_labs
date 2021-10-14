(ns lab2_test
  (:use clojure.algo.generic.math-functions)
  (:require [clojure.test :refer :all]
            [clojure.algo.generic :refer :all]
            [lab2.lab2_1 :refer :all]
            [lab2.lab2_2 :refer :all]))

(defmacro get-time [expr]
  `(Float/parseFloat
     (second (re-find #": (.+) "
                      (with-out-str
                        (time ~expr))))))

(def pow4 #(Math/pow % 4))

(deftest integral-calculation
  (is (approx=
        (let [integral (partial integral-tail 0.001 pow4)] (integral 4))
        (/ (Math/pow 4 5) 5)
        1e-2))
  (is (approx=
        (let [integral (create_integral_fn 0.1 pow4)] (integral 4))
        (/ (Math/pow 4 5) 5)
        1.))
  (is (approx=
        (let [integral (create_seq_integral_fn 0.001 pow4)] (integral 4))
        (/ (Math/pow 4 5) 5)
        1e-2))
  )

(deftest assert-memoized-faster-ten-times
  (is (<
        (let [f (create_integral_fn 1/100 pow4)]
          (* 10 (get-time (dotimes [i 100] (f i)))))

        (get-time (dotimes [i 100] (integral-tail 1/100 pow4 (* i 3)))))))


(defn time_test_fn [f]
  (do
    (time (f 20))
    (time (f 40))
    (time (f 41))
    (time (f 40))
    (time (f 20))
    (time (f 30))
    (time (f 10))
    (time (f 20))
    (time (f 3))
    (println)
    ))
(def step 1/10)
(def f pow4)
(println ((create_integral_fn step f) 1))


(time_test_fn (partial integral-tail step f))
(time_test_fn (create_integral_fn step f))
(time_test_fn (create_seq_integral_fn step f))
