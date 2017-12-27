(ns day1.core-test
  (:require [clojure.test :refer :all]
            [day1.core :refer :all]))

(defn string-to-nums [str] 
  (map (fn [^Character c] (Character/digit c 10)) str))

(defn add-last-item-to-start [items] (cons (last items) items))

(defn is-matching-pair [pair] (= (first pair) (second pair)))

(defn find-identical-pairs [pairs] (filter is-matching-pair pairs))

(defn take-first-elements [pairs] (map first pairs))  

(defn calculate-captcha [captcha] 
  (->> captcha
    (string-to-nums)
    (add-last-item-to-start)
    (partition 2 1)
    (find-identical-pairs)
    (take-first-elements)
    (reduce +)))

(def input (slurp "resources/day1.txt"))

(deftest day-one
  (testing "day one tests"
    (is (= 0 (calculate-captcha "123")))
    (is (= 1 (calculate-captcha "112")))
    (is (= 3 (calculate-captcha "1122")))
    (is (= 4 (calculate-captcha "1111")))
    (is (= 0 (calculate-captcha "1234")))
    (is (= 9 (calculate-captcha "91212129")))
    (is (= 997 (calculate-captcha input)))
    
    ))
