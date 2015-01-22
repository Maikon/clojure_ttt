(ns tic_tac_toe.players_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe.players :refer :all]))

(describe "Players"
  (context "getting two players"
    (it "for human vs human"
      (should=
        [{:type :human} {:type :human}]
        (get-choice "1")))

    (it "for human vs computer"
      (should=
        [{:type :human} {:type :computer}]
        (get-choice "2")))

    (it "for computer vs human"
      (should=
        [{:type :computer} {:type :human}]
        (get-choice "3")))

    (it "for computer vs computer"
      (should=
        [{:type :computer} {:type :computer}]
        (get-choice "4")))))
