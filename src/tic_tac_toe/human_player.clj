(ns tic_tac_toe.human_player
  (:require [tic_tac_toe.player :refer :all]))

(defmethod get-move :human [player]
  ((player :move)))
