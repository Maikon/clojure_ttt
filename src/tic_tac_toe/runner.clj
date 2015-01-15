(ns tic_tac_toe.runner
  (:require [tic_tac_toe.game :as game])
  (:gen-class :main true))

(defn -main []
  (game/play))
