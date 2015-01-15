(ns tic_tac_toe.human_player_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.player :as player]
            [tic_tac_toe.human_player :as human]
            [tic_tac_toe.io :as io]))

(describe "Human Player"
  (around [it]
    (with-out-str (it)))

  (it "returns a valid move"
    (should=
      1
      (with-in-str "2\n" (player/get-move {:type :human :move io/get-move})))))
