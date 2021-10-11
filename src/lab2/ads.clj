(ns lab2.ads
  (:use infix.macros))
(defn t-area [a b h]
  (/ (* (+ a b) h) 2))



(def default_step 000.1)
(defn create_integral_fn
  ([f] (create_integral_fn default_step f))
  ([step f]
   (let [inner_integral (memoize
              (fn [fr x]
                (let [prev (- x step)]
                  (if (< prev 0)
                    0
                    (+ (t-area (f x) (f prev) step)
                       (fr  prev))))))
         magic (partial inner_integral inner_integral)]
     (fn [x] (magic x)))))

(let [f (create_integral_fn (partial * 2))]
  (println (f 4)))

(let [a 2] a)
