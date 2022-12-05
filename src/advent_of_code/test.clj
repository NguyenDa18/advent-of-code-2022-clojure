(ns advent-of-code.test)

(def entries [{:month 1 :val 12}
              {:month 2 :val 3}
              {:month 3 :val 32}
              {:month 4 :val 18}
              {:month 5 :val 32}
              {:month 6 :val 62}
              {:month 7 :val 12}
              {:month 8 :val 142}
              {:month 9 :val 52}
              {:month 10 :val 18}
              {:month 11 :val 23}
              {:month 12 :val 56}])
(defn get-result
  [coll m]
  (->> coll
       (take-while
        #(<= (:month %) m))))

(defn get-total
  [coll m]
  (->>
   (get-result coll m)
   (map #(:val %))
   (reduce +)))

(get-total entries 3)