(ns tic_tac_toe.game_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.game :refer :all]
            [tic_tac_toe.io :refer [print-board]]))

(describe "Game"
  (with-stubs)
  (with print-board-stub (stub :print-board))
  (around [it]
    (with-out-str (with-redefs [print-board @print-board-stub] (it))))

  (it "plays the game with specific players"
    (should=
      {:board ["x" "x" "x" "" "o" "" "" "" "o"]
       :players [{:type :human} {:type :human}]}
      (with-in-str
        "1\n5\n2\n9\n3"
        (play {:board ["" "" "" "" "" "" "" "" ""]
               :players [{:type :human} {:type :human}]}))))

  (it "displays the board"
    (let [game (with-in-str
                 "1\n5\n2\n9\n3"
                 (play {:board ["" "" "" "" "" "" "" "" ""]
                        :players [{:type :human} {:type :human}]}))]
      (should-have-invoked :print-board)))

    (context "turn of players"
      (it "is changed when a move is made"
        (should= {:board ["x" "" "" "" "" "" "" "" ""]
                  :players [{:type :computer} {:type :human}]}
                 (with-in-str "1\n" (next-player-makes-move
                                      ["" "" "" "" "" "" "" "" ""]
                                      [{:type :human} {:type :computer}]))))

      (it "is not changed when an invalid move is made"
        (should= {:board ["x" "" "" "" "" "" "" "" ""]
                  :players [{:type :human} {:type :computer}]}
                 (with-in-str "1\n" (next-player-makes-move
                                      ["x" "" "" "" "" "" "" "" ""]
                                      [{:type :human} {:type :computer}]))))))
