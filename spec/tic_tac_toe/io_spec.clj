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

    (it "validates the move"
      (should=
        1
        (with-in-str "some-invalid-move\n2" (get-move))))))

