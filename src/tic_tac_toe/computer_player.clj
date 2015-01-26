(ns tic_tac_toe.computer_player
  (:require [tic_tac_toe.player :as player]
            [tic_tac_toe.board :refer :all]))

(defn opponent-of [mark]
  (cond
    (= "x" mark) "o"
    :else "x"))

(defn score-board [board]
  (let [score (/ 10.0 (- (count board)
                         (count (available-moves board))))]
    (- score)))

(defn next-board-with-move [board move]
  {:board (mark-position board move (current-mark board))
   :move move})

(defn get-nodes [board]
  (map
    (partial next-board-with-move board)
    (available-moves board)))

(defn highest-scoring [board]
  (let [moves (available-moves board)]
    (if (over? board)
      (score-board board)
      (apply max (map #(- (highest-scoring (mark-position board % (current-mark board)) )) moves)))))

(defn score-and-move [mark {:keys [board move]}]
  {:score (- (highest-scoring board))
   :move  move})

(defmethod player/get-move :computer [player]
  (:move (apply max-key :score
                (map
                  (partial score-and-move
                           (current-mark (:board player)))
                  (get-nodes (:board player))))))
