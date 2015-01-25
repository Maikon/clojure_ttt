(ns tic_tac_toe.runner
  (:require [tic_tac_toe.game :as game]
            [tic_tac_toe.io :as io]
            [tic_tac_toe.board :refer [new-board]])
  (:gen-class :main true))

(defn -main []
  (let [players (io/get-game-choice)
        choice (io/get-board-size)]
    (game/play {:board (new-board (:board-size choice))
                :players players})))
