(ns tic_tac_toe.game_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.game :refer :all]
            [tic_tac_toe.io :refer [print-board]]))

(describe "Game"
  (with-stubs)
  (with print-board-stub (stub :print-board))
  (around [it]
    (with-out-str (with-redefs [print-board @print-board-stub] (it))))

  (it "plays the game until the end"
    (should=
      ["x" "x" "x"
       ""  "o"  ""
       ""  ""  "o"]
      (with-in-str "1\n5\n2\n9\n3" (play))))

  (it "displays the board"
    (let [game (with-in-str "1\n5\n2\n9\n3" (play))]
      (should-have-invoked :print-board)))

    (it "switches the players"
      (should=
        [{:type :computer} {:type :human}]
        (switch-players [{:type :human} {:type :computer}]))))
