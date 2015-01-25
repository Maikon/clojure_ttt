(ns tic_tac_toe.board_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.board :refer :all]))

(describe "Board"
  (it "default board is 3x3"
    (should= 9 (count (new-board))))

  (it "board size can vary"
    (should= 16 (count (new-board 4))))

  (context "making a move"
    (it "marks a position if move is valid"
      (should=
        ["x" "" "" "" "" "" "" "" ""]
        (mark-position (new-board) 0 "x")))

    (it "returns the board unchanged if move invalid"
      (should=
        ["" "" "" "" "" "" "" "" ""]
        (mark-position (new-board) 10 "x")))

    (it "returns the board unchanged if position is taken"
      (should=
        ["x" "" "" "" "" "" "" "" ""]
        (mark-position ["x" "" "" ""  "" "" ""  "" ""] 0 "o"))))

  (context "returns the rows"
    (it "for 3x3"
      (should=
        '((0 ("" "" "")) (1 ("" "" "")) (2 ("" "" "")))
        (map-indexed list (rows (new-board)))))

    (it "for 4x4"
      (should=
        '((0 ("" "" "" "")) (1 ("" "" "" "")) (2 ("" "" "" "")) (3 ("" "" "" "")))
        (map-indexed list (rows (new-board 4))))))

  (context "winner in 4x4"
    (it "checks winner in a row"
      (should= true (winner? ["x" "x" "x" "x"
                              ""  ""  ""  ""
                              ""  ""  ""  ""
                              ""  ""  ""  ""])))

    (it "checks winner in a column"
      (should= true (winner? ["x" "" "" ""
                              "x" "" "" ""
                              "x" "" "" ""
                              "x" "" "" ""])))

    (it "checks winner in a diagonal"
      (should= true (winner? ["" "" "" "x"
                              "" "" "x" ""
                              "" "x" "" ""
                              "x" "" "" ""]))))

  (context "winning rows"
    (it "first row"
      (should= true (winner? ["x" "x" "x"
                              "" "" ""
                              "" "" ""])))

    (it "second row"
      (should= true (winner? ["" "" ""
                              "x" "x" "x"
                              "" "" ""])))

    (it "third row"
      (should= true (winner? ["" "" ""
                              "" "" ""
                              "x" "x" "x"]))))

  (context "winning columns"
    (it "first column"
      (should= true (winner? ["x" "" ""
                              "x" "" ""
                              "x" "" ""])))

    (it "second column"
      (should= true (winner? ["" "x" ""
                              "" "x" ""
                              "" "x" ""])))

    (it "third column"
      (should= true (winner? ["" "" "x"
                              "" "" "x"
                              "" "" "x"]))))

  (context "winning diagonals"
    (it "first diagonal"
      (should= true (winner? ["x" "" ""
                              "" "x" ""
                              "" "" "x"])))

    (it "second diagonal"
      (should= true (winner? ["" "" "x"
                              "" "x" ""
                              "x" "" ""]))))

  (context "checking for specific winner"
    (it "it's positive if given mark has won"
      (should=
        true
        (winner? ["x" "x" "x" "" "o" "" "o" "" ""] "x")))

    (it "it's negative otherwise"
      (should=
        true
        (nil? (winner? ["x" "x" "x" "" "o" "" "o" "" ""] "o")))))

  (context "available moves"
    (it "returns empty if none"
      (should-be empty? (available-moves ["x" "o" "x"
                                          "o" "x" "o"
                                          "o" "x" "o"])))

    (it "returns list of moves otherwise"
      (should= [0 2 4 8] (available-moves ["" "o" ""
                                           "o" "" "o"
                                           "o" "x" ""]))))
  (context "board status"
    (it "when game is ongoing"
      (should= false (over? (new-board))))

    (it "when game has a winner"
      (should= true (over? ["x" "" ""
                            "" "x" ""
                            ""  "" "x"])))
    (it "when game is a draw"
      (should= true (over? ["x" "o" "x"
                            "o" "x" "o"
                            "o" "x" "o"]))))
  (context "current mark for 3x3"
    (it "'x' goes first"
      (should= "x" (current-mark (new-board))))

    (it "'o' goes second"
      (should= "o" (current-mark ["x" "" ""
                                  "" "" ""
                                  "" "" ""]))))

  (context "current mark for 4x4"
    (it "'x' goes first"
      (should= "x" (current-mark (new-board 4))))

    (it "'o' goes second"
      (should= "o" (current-mark (mark-position (new-board 4) 0 "x"))))))
