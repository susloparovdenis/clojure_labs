(ns lab1.lab1_1)

(defn expand-word [alph word]
  (if (empty? alph)
    '()
    (let [rest (expand-word (rest alph) word)]
      (if (= (first alph) (first word))
        rest
        (conj rest (conj word (first alph)))))))

(expand-word '(1 2 3) '(1 2 3))

(defn expand-words [alph words]
  (if (empty? words)
    '()
    (concat
     (expand-word alph (first words))
     (expand-words alph (rest words)))))

(defn perm
  [alph n]
  (if (zero? n)
    '(())
    (expand-words alph (perm alph (dec n)))))

(println (perm '(a b) 5))