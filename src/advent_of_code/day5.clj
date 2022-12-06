(ns advent-of-code.day5
    (:require [clojure.string :as s]))

(def crate-stack [["Z","N"], ["M","C","D"],["P"]])

(defn rearrange-crates [crates-stack, move-amt, move-start, move-end]
    (let [start-idx (- move-start 1)
         end-idx (- move-end 1)
         start-stack (get crates-stack start-idx)
         end-stack (get crates-stack end-idx)
         start-removed-amt (- (count start-stack) move-amt)
         start-removed-crates (vec (drop start-removed-amt start-stack))
         start-stack-post (drop-last move-amt start-stack)
         end-stack-post (concat end-stack start-removed-crates)
         updated-start (assoc crates-stack start-idx start-stack-post)
         res (assoc updated-start end-idx end-stack-post)]
    res))

(defn solve
    [crates-stack]
    (let [crates (atom crates-stack)
        crates (reset! crates (rearrange-crates @crates 1 2 1))]
    crates))
