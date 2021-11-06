(ns lab3.lab3)


(defn my-partition [n coll]
  (lazy-seq (when-let [s (seq coll)]
              (cons (take n s) (my-partition n (drop n s))))))

(defn my-parallel-filter [block-size pred coll]
       (->> coll
            (my-partition block-size )
            (map #(future (filter pred %)))
            (mapcat deref)
            ))



