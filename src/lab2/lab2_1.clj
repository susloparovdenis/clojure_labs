(ns lab2.lab2_1
  (:use infix.macros)
  (:require [lab2.common :refer :all]))

(defn integral-non-tail
  ([step f x]
   (let [prev (- x step)]
     (if (< prev 0)
       0
       (+ (integral-non-tail step f prev) (t-area step (f x) (f prev)))
       ))))

(defn integral-tail
  ([step f x] (integral-tail step f x 0))
  ([step f x acc]
   (let [prev (- x step)]
     (if (< prev 0)
       acc
       (recur step f prev (+ acc (t-area step (f x) (f prev))))))))


(defn create_integral_fn
  ([f] (create_integral_fn default_step f))
  ([step f]
   (let [integral
         (memoize
           (fn [integral x]
             (let [prev (- x step)]
               (if (< prev 0)
                 0
                 (+ (t-area step (f x) (f prev))
                    (integral integral prev))))))]
     (partial integral integral))))

