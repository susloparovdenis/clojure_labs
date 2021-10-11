(ns lababa)





(defn expand-word [alph word acc]
  (if (empty? alph)
    acc
    (recur
      (rest alph)
      word
      (if  (= (first alph) (first word))
        acc
        (conj acc (conj word (first alph)))))))

(defn expand-words [alph words acc]
  (if (empty? words)
    acc
    (recur
      alph
      (rest words)
      (concat acc (expand-word alph (first words) '())))))


(defn perm
  [alph n]
  (loop [n n acc '(())]
    (if (zero? n)
      acc
      (recur
        (dec n)
        (expand-words alph acc '())))))



(println (perm '(a b ) 5))