(ns lab-1.core)
(defn perm [alph n]
  (if (zero? n)
    (list [])
    (for [head alph
          tail (perm
                (remove #{head} alph) (dec n))]
      (cons head tail))))
(perm ['a' 'b' 'c'] 2)


(defn perm2 [alph n]
  (if (zero? n)
    (list [])
    (lazy-seq
     (apply concat (for [x alph]
                     (map #(cons x %) (perm2 (remove #{x} alph) (dec n))))))))


(perm2 ['a' 'b' 'c'] 2)
(cons 0 [1,2,3,4])
