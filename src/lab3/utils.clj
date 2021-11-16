(ns lab3.utils)


(defn my-partition [n coll]
  (lazy-seq (when-let [s (seq coll)]
              (cons (take n s) (my-partition n (drop n s))))))

(defn is-odd [n]
  (zero? (mod n 2)))

(defn heavy-is-odd [n]
  (Thread/sleep 10)
  (zero? (mod n 2)))


(defmacro get-time [expr]
  `(Float/parseFloat
     (second (re-find #": (.+) "
                      (with-out-str
                        (time ~expr))))))
