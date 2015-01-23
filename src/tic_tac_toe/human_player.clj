(ns tic_tac_toe.human_player
  (:require [tic_tac_toe.player :as player]
            [tic_tac_toe.io :as io]))

(defmethod player/get-move :human [player]
  (io/get-move))
