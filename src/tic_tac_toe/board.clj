(ns tic_tac_toe.board)

(declare rows)

(defn new-board
  ([] (vec (range 0 9)))
  ([size] (vec (range 0 (* size size)))))

(defn mark-position
  [board position mark]
  (assoc board position mark))

(defn rows [board]
  (partition
    (int (Math/sqrt (count board)))
    board))
