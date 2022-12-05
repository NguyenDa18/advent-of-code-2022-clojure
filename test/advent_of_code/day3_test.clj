(ns advent-of-code.day3-test
    (:require [clojure.test :refer :all]
            [clojure.string :as s]
            [advent-of-code.day3 :as d3]))

(def rucksack-part-1 [
    "vJrwpWtwJgWrhcsFMMfFFhFp"
    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
    "PmmdzqPrVvPwwTWBwg"
    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
    "ttgJtRGJQctTZtZT"
    "CrZsJsPPZsGzwwsLwLmpwMDw"])

(def day3-input (s/split-lines (slurp "src/advent_of_code/data/day3.txt")))
(def group-rucksacks (vec (partition 3 day3-input)))


(deftest day3
    (testing "Test for day3 part 1"
        (is (= 157 (d3/solve-part-1 rucksack-part-1))))
    (testing "Test for day3 part 2"
        (is (= 2585 (d3/solve-part-2 group-rucksacks)))))