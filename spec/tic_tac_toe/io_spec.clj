(ns tic_tac_toe.io_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.io :refer :all]))

(describe "IO"
  (around [it]
    (with-out-str (it)))

  (it "it prints the board"
    (should=
      "\n1 | 2 | 3 \n4 | 5 | 6 \n7 | 8 | 9\n"
      (with-out-str (print-board ["" "" ""
                                  "" "" ""
                                  "" "" ""]))))

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
        "Please choose a game option from 1-2:\n1) Human vs Com 2) Human vs Com\n"
        (with-out-str (with-in-str "1" (get-game-choice)))))

    (it "returns correct form of user's game choice"
      (should=
        :hvh
        (with-in-str "1" (get-game-choice))))

    (it "validates the game choice"
      (should=
        :hvh
        (with-in-str "invalid-choice\n1" (get-game-choice))))))

