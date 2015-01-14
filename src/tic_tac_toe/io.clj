(ns tic_tac_toe.io
  (:require [tic_tac_toe.board :refer :all :as board]))

(defn print-board [brd]
 (let [pos-counter (range 1 10)]
   (apply println
          (map
            #(apply str "\n" (interpose " | " %))
            (board/rows (map #(if (empty? %1) %2 %1) brd pos-counter))))))

(defn get-move []
  (println "Please choose a move")
  (let [input (read-string (read-line))]
    (if (number? input)
      (dec input)
      (get-move))))

(defn get-game-choice []
  (let [options {"1" :hvh "2" :hvc}
        input (options (read-line))]
  (println "Please choose a game option from 1-2:")
  (println "1) Human vs Com 2) Human vs Com")
  (if input
    input
    (get-game-choice))))
