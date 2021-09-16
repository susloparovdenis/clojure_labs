(ns lab1)
;1.1
(defn perm [alph n]
  (if (zero? n)
    [[]]
    (for  [head alph
           tail (perm (remove #{head} alph) (dec n))]
      (cons head tail))))

;1.2
(defn perm_tail
  ([alph n]
   (perm_tail alph n (for [a alph] [a])))
  ([alph n acc]
   (if (= n 1)
     acc
     (recur alph (dec n) (for [el   acc
                               head (remove (set el) alph)]
                           (conj el head))))))

;1.3
(defn my-map [f coll]
  (reduce #(conj %1 (f %2)) [] coll))

(defn  my-filter [f coll]
  (reduce #(if (f %2) (conj %1 %2) %1) [] coll))

(defn my-mapcat
  ([f & colls]
   (apply concat (apply my-map f colls))))

;1.4

(defn perm3 [alph n]
  (if (< n 1)
    [[]]

    (my-mapcat (fn [x]
                 (map cons
                      (repeat x)
                      (perm3 (disj (set alph) x) (dec n))))
               alph)))

