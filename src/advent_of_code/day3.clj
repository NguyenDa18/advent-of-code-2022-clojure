(ns advent-of-code.day3
    (:require [clojure.set :as set]
            [clojure.string :as s]))

; (load-file "src/advent_of_code/day3.clj")

; Sources
; intersection with Clojure search https://stackoverflow.com/questions/36046879/determine-if-vectors-intersects-in-clojure
; iterate over two lists with Clojure https://stackoverflow.com/questions/9121576/clojure-how-to-execute-a-function-on-elements-of-two-seqs-concurently

"""
Advent of Code Day 3: https://adventofcode.com/2022/day/3
"""
(defn letter-to-val [a b] (vector a b))

(def lower-case-letters (map char (range 97 123)))
(def lower-case-values (range 1 27))

(def upper-case-letters (map char (range 65 91)))
(def upper-case-values (range 27 53))

(def lower-case-map (into (sorted-map) (map letter-to-val lower-case-letters lower-case-values)))
(def upper-case-map (into (sorted-map) (map letter-to-val upper-case-letters upper-case-values)))
(def letters-map (merge lower-case-map upper-case-map))

;; part 1
(defn common-item-type
    [compartments]
    (let [half-index (/ (count compartments) 2)
        halves (split-at half-index compartments)
        left (vec (get halves 0))
        right (vec (get halves 1))]
    (some (set left) right)))

(defn sum-of-priorities
    [rucksack]
    (->>
        (map common-item-type rucksack)
        (map #(get letters-map %))
        (reduce +)))

(defn solve-part-1
    [rucksack]
    (let [common-item-types (map common-item-type rucksack)]
        (sum-of-priorities rucksack)))

;; part 2
(defn common-badge
    [input]
    (let [partitions (vec input)
        common-letter (set/intersection (set (get partitions 0))
                                        (set (get partitions 1))
                                        (set (get partitions 2)))]
    common-letter))

(defn solve-part-2
    [rucksacks-vec]
    (let [common-badges (mapv common-badge rucksacks-vec)
            priority-values (mapv #(get letters-map (get (vec %) 0)) common-badges)]
        (reduce + priority-values)))

