(ns tic_tac_toe.computer_player_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.computer_player :refer :all]
            [tic_tac_toe.player :refer :all]))

(describe "Computer Player"
  (context "finding opponent"
    (it "for 'x'"
      (should= "o" (opponent-of "x")))

    (it "for 'o'"
      (should= "x" (opponent-of "o"))))

  (it "goes for the win"
    (should=
      2
      (get-move {:type :computer :board ["x" "x" ""
                                         "o" "o" ""
                                         "" "" ""]})))
  (it "blocks opponent's win"
    (should=
      4
      (get-move {:type :computer :board ["x" "" ""
                                         "o" "" "o"
                                         "" "x" ""]})))
  (it "blocks diagonal fork"
    (should=
      7
      (get-move {:type :computer :board ["x" "" ""
                                         "" "o" ""
                                         "" "" "x"]})))

  (it "blocks alternative diagonal fork"
    (should=
      6
      (get-move {:type :computer :board ["x" "" ""
                                         "" "x" ""
                                         "" ""  "o"]})))

  (it "blocks edges fork"
    (should=
      8
      (get-move {:type :computer :board ["" "" ""
                                         "" "o" "x"
                                         "" "x" ""]}))))
