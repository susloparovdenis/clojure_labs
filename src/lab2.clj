(ns lab2)

(def step 0.01)

(defn t-area [a b h]
  (/ (* (+ a b)  h) 2))


(defn integral
  ([f x] (integral f x 0))
  ([f x acc]
   (if (<= x 0) acc
       (let [prev (- x step)
             area (t-area (f x) (f prev) step)]
         (recur f prev (+ acc area))))))

(def memoized-integral
  (memoize integral))


(defn pow4 [x] (reduce * (repeat 4 x)))


(time (dotimes [i 4] (memoized-integral pow4 1002)) )  
(time (dotimes [i 4] (integral pow4 1002)))
