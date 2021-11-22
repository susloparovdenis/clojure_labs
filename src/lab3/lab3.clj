(ns lab3.lab3
  (:use lab3.utils))


(defn my-parallel-filter [block-size pred coll]
  (->> coll
       (my-partition block-size)
       (map #(future (doall (filter pred %))))
       (doall)
       (mapcat deref)))

(defn my-parallel-filter2 [block-size threads pred coll]
  (->> coll
       (my-partition block-size)
       (my-partition threads)
       (mapcat
         (fn [group]
           (->> group
                (map #(future (doall (filter pred %))))
                (doall)
                (mapcat deref)))
         )
       ))
(take 10 (my-parallel-filter2 2 4 heavy-is-odd (range)))

(get-time (doall (my-parallel-filter 1 heavy-is-odd (range 100))))
(get-time (doall (my-parallel-filter2 2 10 heavy-is-odd (range 100))))