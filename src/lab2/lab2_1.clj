(ns lab2.lab2_1  )

(def step 0.01)

(defn t-area [a b h]
  (/ (* (+ a b) h) 2))


(defn integral
  ([f x] (integral f x 0))
  ([f x acc]
   (if (<= x 0) acc
                (let [prev (- x step)
                      area (t-area (f x) (f prev) step)]
                  (recur f prev (+ acc area))))))

(def memoized-integral
  (memoize integral))




