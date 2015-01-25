(ns tic_tac_toe.io
  (:require [tic_tac_toe.board :as board]
            [tic_tac_toe.players :as players]))

(defn print-board [brd]
 (let [pos-counter (range 1 (+ 1 (count brd)))]
   (apply println
          (map
            #(apply str "\n" (interpose " | " %))
            (board/rows (map #(if (empty? %1) %2 %1) brd pos-counter))))))

(defn get-move []
  (println "Please choose a move")
  (let [input (read-line)]
    (if (and (not (empty? input)) (number? (read-string input)))
      (dec (read-string input))
      (get-move))))

(defn get-game-choice []
  (println "Please choose a game option from 1-4:")
  (println "1) Human vs Human 2) Human vs Computer 3) Computer vs Human 4) Computer vs Computer")
  (let [choice (players/get-choice (read-line))]
    (if choice
      choice
      (get-game-choice))))

(defn get-board-size []
  (println "Please choose a board size:")
  (println "1) 3x3 2) 4x4")
  (let [sizes {:1 {:board-size 3} :2 {:board-size 4}}
        choice ((keyword (read-line)) sizes)]
    (if choice
      choice
      (get-board-size))))
