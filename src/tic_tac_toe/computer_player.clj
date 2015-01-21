(ns tic_tac_toe.computer_player)

(defn opponent-of [mark]
  (cond
    (= "x" mark) "o"
    :else "x"))
