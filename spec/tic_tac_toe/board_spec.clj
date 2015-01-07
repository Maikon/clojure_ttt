(ns tic_tac_toe.board_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.board :refer :all]))

(describe "Board"
          (it "default board is 3x3"
              (should= 9 (count (new-board))))

          (it "board size can vary"
              (should= 16 (count (new-board 4)))))
