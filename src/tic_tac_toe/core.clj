(ns tic_tac_toe.core
  (:require [tic_tac_toe.board :refer :all :as board]
            [tic_tac_toe.io :refer :all :as io])
  (:gen-class :main true))

(defn -main []
  (loop [b (board/new-board)]
    (io/print-board b)
    (if (not (board/over? b))
    (recur (board/mark-position
             b
             (dec (read-string (io/get-move)))
             (board/current-mark b))))))
