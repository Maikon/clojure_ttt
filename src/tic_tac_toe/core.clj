(ns tic_tac_toe.core
  (:require [tic_tac_toe.board :refer [new-board over?  mark-position current-mark]]
            [tic_tac_toe.io :refer [print-board get-move]])
  (:gen-class :main true))

(defn -main []
  (loop [board (new-board)]
    (print-board board)
    (if (not (over? board))
    (recur (mark-position
             board
             (dec (read-string (get-move)))
             (current-mark board))))))
