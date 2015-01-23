(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :as board]
            [tic_tac_toe.io :as io]
            [tic_tac_toe.player :as player]
            [tic_tac_toe.human_player]))

(declare next-player-makes-move)

(defn play [game]
   (loop [updated-game game]
     (io/print-board (:board updated-game))
     (if (not (board/over? (:board updated-game)))
       (recur (next-player-makes-move (:board updated-game) (:players updated-game)))
       updated-game)))

(defn switch-players [players]
  (reverse players))

(defn next-player-makes-move [board players]
  (let [new-board (board/mark-position board
                                       (player/get-move (first players))
                                       (board/current-mark board))]
    (hash-map :board new-board :players (switch-players players))))
