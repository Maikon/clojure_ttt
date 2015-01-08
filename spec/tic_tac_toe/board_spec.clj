(ns tic_tac_toe.board_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.board :refer :all]))

(describe "Board"
          (it "default board is 3x3"
              (should= 9 (count (new-board))))

          (it "board size can vary"
              (should= 16 (count (new-board 4))))

          (it "mark a position"
              (should=
                ["x" 1 2 3 4 5 6 7 8]
                (mark-position (new-board) 0 "x")))

          (it "returns the rows"
              (should=
                '((0 1 2) (3 4 5) (6 7 8))
                (rows (new-board)))))
