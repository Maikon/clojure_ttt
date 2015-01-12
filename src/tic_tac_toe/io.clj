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
  (read-line))
