(ns advent-of-code.day5-test
    (:require [clojure.test :refer :all]
            [clojure.string :as s]
            [advent-of-code.day5 :as d5]))

(def crate-stack-part1-demo [["Z","N"], ["M","C","D"],["P"]])

(def crate-stack-part1 [
    ["P", "F", "M", "Q", "W", "G", "R", "T"],
    ["H", "F", "R"],
    ["P", "Z", "R", "V", "G", "H", "S", "D"],
    ["Q", "H", "P", "B", "F", "W", "G"],
    ["P", "S", "M", "J" "H"]
    ["M", "Z" "T" "H" "S" "R" "P" "L"],
    ["P" "T" "H" "N" "M" "L"],
    ["F" "D" "Q" "R"]
    ["D" "S" "C" "N" "L" "P" "H"]
])

(def day5-part-1-input (s/split-lines (slurp "src/advent_of_code/data/day5-moves.txt")))

(def day5-part-1-moves
    (map #(s/split % #"") day5-part-1-input))

(deftest day5
    (testing "Test for day5 part 1 demo"
        (is (= [["C"], ["M"], ["P" "D" "N" "Z"]] (d5/solve-part1-demo crate-stack-part1-demo)))))