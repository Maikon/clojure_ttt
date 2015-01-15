(ns tic_tac_toe.player)

(defmulti get-move
  (fn [player] (player :type)))
