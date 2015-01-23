(ns tic_tac_toe.game
  (:require [tic_tac_toe.board :as board]
            [tic_tac_toe.io :as io]
            [tic_tac_toe.player :as player]
            [tic_tac_toe.human_player]))

(defn play []
  (loop [board (board/new-board)]
    (io/print-board board)
    (if (not (board/over? board))
      (recur (board/mark-position
               board
               (io/get-move)
               (board/current-mark board)))
      board)))

(defn switch-players [players]
  (reverse players))

(defn next-player-makes-move [board players]
  (let [new-board (board/mark-position board
                                       (player/get-move (first players))
                                       (board/current-mark board))]
    (hash-map :board new-board :players (switch-players players))))
