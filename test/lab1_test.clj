(ns lab1_test
  (:require [clojure.test :refer :all]
            [lab1 :refer :all]))

(deftest perm-test
 (testing "FIXME, I fail."
    (is (= (perm [1 2 3] 2) '((1 2) (1 3) (2 1) (2 3) (3 1) (3 2))))))

(deftest perm_tail-test
  (testing "FIXME, I fail."
    (is (= (perm_tail [1 2 3] 2) '((1 2) (1 3) (2 1) (2 3) (3 1) (3 2))))))

