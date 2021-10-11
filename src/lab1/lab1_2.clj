(ns lab1.lab1_2)

(defn expand-word [alph word acc]
  (if (empty? alph)
    acc
    (recur
      (rest alph)
      word
      (if (= (first alph) (first word))
        acc
        (cons (cons (first alph) word) acc)))))

(defn expand-words [alph words acc]
  (if (empty? words)
    acc
    (recur
      alph
      (rest words)
      (concat acc (expand-word alph (first words) '())))))

(expand-word '(1 2 3) '(1 2 3) ())
(defn perm
  [alph n]
  (loop [n n acc '(())]
    (if (zero? n)
      acc
      (recur
        (dec n)
        (expand-words alph acc '())))))

(println (perm '(a b) 5))
