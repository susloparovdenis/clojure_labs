(ns lab3_test
  (:use [clojure.test]
        [lab3.lab3]
        [lab3.utils]))

(testing "correctness"

  (deftest my-partition-test
    (is (=
          '((0 1 2) (3 4 5) (6 7 8) (9))
          (my-partition 3 (range 10))
          )
        )
    )
  (deftest my-parallel-filter-test
    (is (=
          '(0 2 4 6 8)
          (my-parallel-filter 3 is-odd (range 10))
          )))
  (deftest my-parallel-filter2-test
    (is (=
          '(0 2 4 6 8)
          (my-parallel-filter2 2 3 is-odd (range 10))
          )))
  )


(testing "performance"
  (deftest parallel-filter-faster
    (is (<
          (* 5 (get-time (my-parallel-filter 1 heavy-is-odd (range 100))))
          (get-time (doall (filter heavy-is-odd (range 100))))))
    )

  (deftest parallel-filter2-faster
    (is (<
          (* 5 (get-time (my-parallel-filter2 10 10 heavy-is-odd (range 100))))
          (get-time
            (doall
              (filter heavy-is-odd (range 100))))))
    )
  )



(deftest my-parallel-filter2-with-inf-seq
  (is (=
        '(0 2 4 6 8)
        (take 5 (my-parallel-filter2 2 3 is-odd (range)))))
  )

