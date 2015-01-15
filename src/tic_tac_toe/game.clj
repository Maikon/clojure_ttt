(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :refer [new-board over? mark-position current-mark]]
            [tic_tac_toe.io :as io]))

(defn play []
  (loop [board (new-board)]
    (io/print-board board)
    (if (not (over? board))
      (recur (mark-position
               board
               (io/get-move)
               (current-mark board)))
      board)))
