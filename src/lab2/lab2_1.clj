(ns lab2.lab2_1
  (:use infix.macros))


(def default_step 000.1)

(defn t-area [a b h]
  ($= (a + b) * h / 2.0))
;(/ (* (+ a b) h) 2))

;
(defn integral-tail
  ([f x] (integral-tail f x 0))
  ([f x acc]
   (let [prev (- x default_step)]
     (if (< prev 0)
       acc
       (recur f prev (+ acc (t-area (f x) (f prev) default_step)))))))

(defn create_integral_fn
  ([f] (create_integral_fn default_step f))
  ([step f]
   (let [inner_integral (memoize
              (fn [f x]
                (let [prev (- x step)]
                  (if (< prev 0)
                    0
                    (+ (t-area (f x) (f prev) step)
                       (f prev))))))
         magic (partial inner_integral inner_integral)]
     (magic)
     )))
(defn pow4 [x] (Math/pow * (repeat 4 x)))
(defn pow3 [x] (Math/pow x 3))
(pow3 4)
(create_integral_fn pow3 2)
(integral pow3 10)
(integral-tail pow3 10)
((create_integral_fn pow3) 10)

(letfn [x] (println x))
(cons 4 '(1, 2, 3))

(defn testsaa [i]
  (memoize (fn [i] (do (println i)) (testsaa (inc i)))

           (trampoline my-even? 1000000)
           (testsaa 0)

           (swap!