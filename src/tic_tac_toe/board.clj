(ns tic_tac_toe.board)

(defn new-board
  ([] (vec (range 0 9)))
  ([size] (vec (range 0 (* size size)))))
