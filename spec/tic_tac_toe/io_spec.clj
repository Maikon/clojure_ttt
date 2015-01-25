(ns tic_tac_toe.io_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.io :refer :all]))

(describe "IO"
  (around [it]
    (with-out-str (it)))

  (it "it prints a 3x3 board"
    (should=
      "\n1 | 2 | 3 \n4 | 5 | 6 \n7 | 8 | 9\n"
      (with-out-str (print-board ["" "" ""
                                  "" "" ""
                                  "" "" ""]))))
  (it "it prints a 4x4 board"
    (should=
      "\n1 | 2 | 3 | 4 \n5 | 6 | 7 | 8 \n9 | 10 | 11 | 12 \n13 | 14 | 15 | 16\n"
      (with-out-str (print-board ["" "" "" ""
                                  "" "" "" ""
                                  "" "" "" ""
                                  "" "" "" ""]))))

  (context "getting move from user"
    (it "asks for user input"
      (should=
        "Please choose a move\n"
        (with-out-str (with-in-str "1" (get-move)))))

    (it "returns user input"
      (should=
        0
        (with-in-str "1" (get-move))))

    (it "handles wrong input"
      (should=
        1
        (with-in-str "some-invalid-move\n2" (get-move))))

    (it "handles empty input"
      (should=
        1
        (with-in-str "\n2" (get-move)))))

  (context "getting game choice"
    (it "asks the user to select game"
      (should=
        "Please choose a game option from 1-4:\n1) Human vs Human 2) Human vs Computer 3) Computer vs Human 4) Computer vs Computer\n"
        (with-out-str (with-in-str "1" (get-game-choice)))))

    (it "returns correct form of user's game choice"
      (should=
        [{:type :human} {:type :human}]
        (with-in-str "1" (get-game-choice))))

    (it "validates the game choice"
      (should=
        [{:type :human} {:type :human}]
        (with-in-str "invalid-choice\n1" (get-game-choice)))))

  (context "choosing board size"
    (it "asks user for the size"
      (should=
        "Please choose a board size:\n1) 3x3 2) 4x4\n"
        (with-out-str (with-in-str "1" (get-board-size)))))

    (it "returns user input for 3x3"
      (should=
        {:board-size 3}
        (with-in-str "1" (get-board-size))))

    (it "returns user input for 4x4"
      (should=
        {:board-size 4}
        (with-in-str "2" (get-board-size))))

    (it "validates user choice"
      (should=
        {:board-size 3}
        (with-in-str "invalid\n1" (get-board-size))))))
