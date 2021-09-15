(ns lab1_test
  (:require [clojure.test :refer :all]
            [lab1 :refer :all]))

(deftest perm-test
 (testing "FIXME, I fail."
    (is (= (perm [1 2 3] 2) '((1 2) (1 3) (2 1) (2 3) (3 1) (3 2))))))

(deftest perm_tail-test
    (is (= (perm_tail [1 2 3] 2) '((1 2) (1 3) (2 1) (2 3) (3 1) (3 2)))))

(deftest my-map-test
  (is (= (my-map inc [1 2 3 4] ) [2 3 4 5])))

(deftest my-filter-test
  (is (= (my-filter #(> %1 2) [1,2,3,4]) [3 4])))
