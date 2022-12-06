(ns advent-of-code.day5-test
    (:require [clojure.test :refer :all]
            [clojure.string :as s]
            [advent-of-code.day5 :as d5]))

(def crate-stack [["Z","N"], ["M","C","D"],["P"]])

(deftest day5
    (testing "Test for day5 part 1"
        (is (= [["Z", "N", "D"], ["M", "C"], ["P"]] (d5/solve crate-stack)))))