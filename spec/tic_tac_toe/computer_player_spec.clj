(ns tic_tac_toe.computer_player_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.computer_player :refer :all]))

(describe "Computer Player"
  (context "finding opponent"
    (it "for 'x'"
      (should= "o" (opponent-of "x")))

    (it "for 'o'"
      (should= "x" (opponent-of "o")))))
