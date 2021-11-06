(ns lab3_test
  (:require [clojure.test :refer :all]
            [lab3.lab3_1 :refer :all]))

(defn heavy-is-odd [n]
  (Thread/sleep 100)
  (zero? (mod n 2)))

(defmacro get-time [expr]
  `(Float/parseFloat
     (second (re-find #": (.+) "
                      (with-out-str
                        (time ~expr))))))


(deftest my-partition-test
  (is (= (my-partition 3 (range 10))
         '((0 1 2) (3 4 5) (6 7 8) (9))
         )
      )
  )
(deftest my-parallel-filter-test
  (is (= (my-parallel-filter 3 #(< % 5) (range 10))
         '(0 1 2 3 4)
         )))

(deftest assert-memoized-faster-ten-times
  (is (< (* 5 (get-time (my-parallel-filter 1 heavy-is-odd (range 10))))
         (get-time (doall (filter heavy-is-odd (range 10)))))))

(get-time (my-parallel-filter 1 heavy-is-odd (range 10)))
(get-time (doall (filter heavy-is-odd (range 10))))

(filter heavy-is-odd (range 100))

(heavy-is-odd 6)