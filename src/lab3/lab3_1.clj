(ns lab3.lab3_1)




(defn my-partition [n coll]
  (lazy-seq (when-let [s (seq coll)]
              (cons (take n s) (my-partition n (drop n s))))))

(defn my-parallel-filter [block-size pred coll]
       (->> coll
            (my-partition block-size )
            (map #(future (filter pred %)))
            (doall)
            (mapcat deref)
            ))

(my-parallel-filter  3 #(< % 5) (range 10))

