(ns lab1.lab1_3)

(defn my-map
  [f coll]
  (reduce (fn [acc val] (conj acc (f val))) [] coll))

(defn my-flat-map
  [f coll]
  (reduce (fn [acc val] (concat acc (f val))) [] coll))


(defn my-filter
  [f coll]
  (reduce
    (fn [acc val]
      (if (f val)
        (conj acc val)
        acc))
    [] coll))

(println (my-map (partial * 2) [1 2 3 4 5]))
(println (my-filter (partial < 3) [1 2 3 4 5]))