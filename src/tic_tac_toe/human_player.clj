(ns tic_tac_toe.human_player
  (:require [tic_tac_toe.board :refer :all]))

(defn make-move [board position mark]
  (mark-position board position mark))
