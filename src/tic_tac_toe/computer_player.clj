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
  (cond
    (winner? board (current-mark board)) score
    (and (over? board) (not (winner? board))) 0
    :else (unchecked-negate score))))

(defn next-board-with-move [board move]
  {:board (mark-position board move (current-mark board))
   :move move})

(defn get-nodes [board]
  (map
    (partial next-board-with-move board)
    (available-moves board)))

(defn score [board]
  (let [moves (available-moves board)]
    (if (over? board)
      (score-board board)
      (apply max (map #(- (score (mark-position board % (current-mark board)) )) moves)))))

(defn score-and-move [mark {:keys [board move]}]
  {:score (- (score board))
    :move  move})

(defmethod player/get-move :computer [player]
  (:move (apply max-key :score
                (map
    (partial score-and-move
             (current-mark (:board player)))
    (get-nodes (:board player))))))
