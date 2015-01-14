(ns tic_tac_toe.human_player_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.human_player :refer :all]))

(describe "Human Player"
  (before
    (def board ["" "" ""
                "" "" ""
                "" "" ""]))

  (it "makes a move on a board"
    (should=
      ["x" "" "" "" "" "" "" "" ""]
      (make-move board 0 "x"))))
