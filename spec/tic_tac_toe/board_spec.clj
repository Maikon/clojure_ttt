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
                         ["x" 1 2 3 4 5 6 7 8]
                         (mark-position (new-board) 0 "x")))

                   (it "raises custom exception if move is invalid"
                       (should-throw Exception "Invalid Move"
                                     (mark-position (new-board) 10 "x"))))

          (it "returns the rows"
              (should=
                '((0 1 2) (3 4 5) (6 7 8))
                (rows (new-board))))

          (context "winning rows"
                   (it "first row"
                       (should= true (winner? ["x" "x" "x"
                                               3 4 5
                                               6 7 8])))

                   (it "second row"
                       (should= true (winner? [0 1 2
                                               "x" "x" "x"
                                               6 7 8])))

                   (it "third row"
                       (should= true (winner? [0 1 2
                                               3 4 5
                                               "x" "x" "x"])))
                   )

          (context "winning columns"
                   (it "first column"
                       (should= true (winner? ["x" 1 2
                                               "x" 4 5
                                               "x" 7 8])))

                   (it "second column"
                       (should= true (winner? [0 "x" 2
                                               3 "x" 5
                                               6 "x" 8])))

                   (it "third column"
                       (should= true (winner? [0 1 "x"
                                               3 4 "x"
                                               6 7 "x"])))
                   )

          (context "winning diagonals"
                   (it "first diagonal"
                       (should= true (winner? ["x" 1 2
                                               3 "x" 5
                                               6 7 "x"])))

                   (it "second diagonal"
                       (should= true (winner? [0 1 "x"
                                               3 "x" 5
                                               "x" 7 8]))))
          (context "available moves"
                   (it "returns empty if none"
                       (should-be empty? (available-moves ["x" "o" "x"
                                                           "o" "x" "o"
                                                           "o" "x" "o"])))

                   (it "returns list of moves if any"
                       (should= [0 4 8] (available-moves [0 "o" "x"
                                                          "o" 4 "o"
                                                          "o" "x" 8]))))
          (context "board status"
                   (it "when game is ongoing"
                       (should= false (over? (new-board))))

                   (it "when game has a winner"
                       (should= true (over? ["x" 1  2
                                              3 "x" 5
                                              6  7 "x"])))
                   (it "when game is a draw"
                       (should= true (over? ["x" "o" "x"
                                             "o" "x" "o"
                                             "o" "x" "o"]))))
          (context "current mark"
                   (it "'x' goes first"
                       (should= "x" (current-mark (new-board))))

                   (it "'o' goes second"
                       (should= "o" (current-mark ["x" 1 2 3 4 5 6 7 8])))))
