(ns lab1)
;1.1
(defn perm [alph n]
  (if (zero? n)
    (list [])
    (for  [head alph
           tail (perm (remove #{head} alph) (dec n))]
      (cons head tail))))
;1.2
(defn perm_tail ([alph n] (perm_tail alph n (for [a alph] [a])))
  ([alph n acc]
   (if (= n 1)
     acc
     (recur alph (dec n)
            (for [el   acc
                  head (remove (into #{} el) alph)]
              (conj el head))))))

;1.3
(defn my-map [f coll]
  (reduce #(conj %1 (f %2)) [] coll))

(defn  my-filter [f coll]
  (reduce #(if (f %2) (conj %1 %2) %1) [] coll))
