(ns advent-of-code.day5
    (:require [clojure.string :as s]))

; Sources
; https://clojuredocs.org/clojure.core/drop
; https://clojuredocs.org/clojure.core/reverse

"""
Advent of Code Day 5: https://adventofcode.com/2022/day/5
"""
(def crate-stack [["Z","N"], ["M","C","D"],["P"]])

(defn rearrange-crates [crates-stack, move-amt, move-start, move-end]
    (let [
        start-idx (- move-start 1)
         end-idx (- move-end 1)
         start-stack (get crates-stack start-idx)
         end-stack (get crates-stack end-idx)
         start-removed-amt (- (count start-stack) move-amt)
         start-removed-crates (reverse (drop start-removed-amt start-stack))
         start-stack-post (drop-last move-amt start-stack)
         end-stack-post (concat end-stack start-removed-crates)
         updated-start (assoc crates-stack start-idx start-stack-post)
         res (assoc updated-start end-idx end-stack-post)]
    res))

(defn solve-part1-demo
    [crates-stack]
    (let [crates (atom crates-stack)]
        (reset! crates (rearrange-crates @crates 1 2 1))
        (reset! crates (rearrange-crates @crates 3 1 3))
        (reset! crates (rearrange-crates @crates 2 2 1))
        (reset! crates (rearrange-crates @crates 1 1 2))))

(defn solve-part1-puzzle
    [crates-stack]
    (let [crates (atom crates-stack)]
        (reset! crates (rearrange-crates @crates 3 8 9))
        (reset! crates (rearrange-crates @crates 2 2 8))
        (reset! crates (rearrange-crates @crates 5 4 2))
    ))
