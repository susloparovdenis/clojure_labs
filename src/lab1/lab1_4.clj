(ns lab1.lab1_4
  (:require [lab1.lab1_3 :refer :all]))

(defn expand-word [alph word]
  (if (empty? alph)
    '()
    (->> alph
         (my-filter #(not= (first word) %))
         (my-map #(conj word %)))))

(defn expand-words [alph words]
  (if (empty? words)
    '()
    (my-flat-map (fn [word] (expand-word alph word)) words)))

(defn perm
  [alph n]
  (if (zero? n)
    '(())
    (expand-words alph (perm alph (dec n)))))

(println (perm '(a b) 5))
(println (perm '(1 2 3) 3))


