(ns lab2.lab2_2
  (:use infix.macros)
  (:require [lab2.common :refer :all]))

(defn create_seq_integral_fn
  ([f] (create_seq_integral_fn default_step f))
  ([step f]
   (let [ticks (iterate (partial + step) 0)
         f-vals (->> ticks (map f))
         segments (map list f-vals (rest f-vals))
         partial-integrals (->> segments
                                (map vec)
                                (map #(apply (partial t-area step) %)))

         integral (reductions + partial-integrals)]
     (fn [x]
       (let [n (/ x step)]
         (+ (nth integral (dec n))
            (t-area (rem x step) (nth f-vals n) (f x))
            )
         )))))
