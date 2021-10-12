(ns lab2.lab2_1
  (:use infix.macros))

(def default_step (/ 1 1000))

(defn t-area [a b h]
  ($= (a + b) * h / 2.0))

(defn integral-tail
  ([f x] (integral-tail default_step f x))
  ([step f x]
   (loop [cur 0 acc 0]
     (let [next (+ cur step)]
       (if (>= cur x)
         acc
         (recur next (+ acc (t-area (f cur) (f next) step))))))))

(integral-tail (/ 1 1000) (partial * 1) 400)

(defn create_integral_fn
  ([f] (create_integral_fn default_step f))
  ([step f]
   (fn [x]
     (let [integral
           (memoize
            (fn [integral cur acc]
              (let [next (+ cur step)]
                #break
                 (if (>= cur x)
                   acc
                   (recur integral next (+ acc (t-area (f cur) (f next) step)))))))]
       (integral integral 0 0)))))

(defn pow4 [x] (reduce * (repeat 4 x)))
(let [integral (create_integral_fn (/ 1 1000) (partial * 1))] (integral 400))

(/ (pow4 4) 4)