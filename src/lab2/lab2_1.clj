(ns lab2.lab2_1
  (:use infix.macros))

(def default_step (/ 1 40))

(defn t-area [a b h]
  ($= (a + b) * h / 2.0))

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
   (let [integral
         (memoize
          (fn [integral x]
            (let [prev (- x step)]
              (if (< prev 0)
                0
                (+ (t-area (f x) (f prev) step)
                   (integral integral prev))))))]
     (partial integral integral))))
