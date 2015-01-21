(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :as board]
            [tic_tac_toe.io :as io]))

(defn play []
  (loop [board (board/new-board)]
    (io/print-board board)
    (if (not (board/over? board))
      (recur (board/mark-position
               board
               (io/get-move)
               (board/current-mark board)))
      board)))
