(ns tic_tac_toe.human_player
  (:require [tic_tac_toe.player :as player]))

(defmethod player/get-move :human [player]
  ((player :move)))
