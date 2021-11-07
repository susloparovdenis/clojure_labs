(ns lab4_test
  (:use clojure.test)
  (:use lab4.parser)
  (:use lab4.lab4)
  (:use clojure.set))

(deftest parser-test
  (let [test-expr '(a or b or (a and b and c and !c))]
    (is (= test-expr
           (to-infix (to-prefix test-expr))))))

(testing "constant?"
  (is (constant? true))
  (is (constant? false)))

(deftest test-rules
  ; (a => b) => (!a or b)
  (is (=
       '(!x or y)
       (pretty-dnf '(x => y))))

  ; !(a and b and ...) => (!a or !b or ...)
  (is (=
       '(!x or !y)
       (pretty-dnf '(not (x and y)))))

  ; !(a or b or ...) => (!a and !b and ...)
  (is (=
       '(!x and !y)
       (pretty-dnf '(not (x or y)))))

  ; (!!a) => (a)
  (is (=
       'x
       (pretty-dnf '(not (not x)))))

  ; true or ... => true
  (is (=
       true
       (pretty-dnf '(true or x or y))))

  ; !x or x => true
  (is (=
       true
       (pretty-dnf '(!x or x))))

  ; !x and x => false
  (is (=
       false
       (pretty-dnf '(!x and x))))

  ; false or ... => ...
  (is (=
       '(x or y)
       (pretty-dnf '(false or x or y))))

  ; false and ... => false
  (is (=
       false
       (pretty-dnf '(x and false and y))))

  ; true and ... => ...
  (is (=
       '(x and y)
       (pretty-dnf '(x and true and y))))

  ; !true = false, !false = true
  (is (=
       false
       (pretty-dnf '(not true))))
  (is (=
       true
       (pretty-dnf '(not false))))

  ; (a and (b or c)) => ((b and a) or (c and a))
  (is (=
       '((b and a) or (c and a))
       (pretty-dnf '(a and (b or c)))))

  ; (a and a and ...) => (a and ...) ,    (a or a or ...) => (a or ...)
  (is (=
       '(x and y)
       (pretty-dnf '(x and x and y and y))))
  (is (=
       '(y and x)
       (pretty-dnf '(y and (x and x)))))

  ; (a or (b or c)) => (a or b or c)
  (is (=
       '(x or y or z)
       (pretty-dnf '(x or (y or z)))))

  ; (a and (b and c)) => (a and b and c)
  (is (=
       '(x and y and z)
       (pretty-dnf '(x and (y and z))))))

(deftest test-dnf
  (is (=
       '(a or b)
       (pretty-dnf '(a or b or (a and b and c and (not c))))))

  (is (=
       '(y and x)
       (pretty-dnf '((x => y) and x))))

  (is (=
       true
       (pretty-dnf '(x or y or (not x))))))
