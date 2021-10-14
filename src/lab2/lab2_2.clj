(ns lab2.lab2_2
  (:use infix.macros)
  (:require [lab2.common :refer :all]))


(defn create_seq_integral_fn
  ([f] (create_seq_integral_fn default_step f))
  ([step f]
   (let [ticks (iterate (partial + step) 0)
         f-vals (lazy-seq (->> ticks (map f)))
         segments (map (partial conj []) f-vals (rest f-vals))
         partial-integrals (->> segments
                                (map #(apply (partial t-area step) %)))

         integral (lazy-seq (reductions + partial-integrals))
         ]
     (fn [x]
       (nth integral (dec (/ x step)))
       ))))
