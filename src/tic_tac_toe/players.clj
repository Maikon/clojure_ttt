(ns tic_tac_toe.players)

(def players
  {:1 [{:type :human} {:type :human}]
   :2 [{:type :human} {:type :computer}]
   :3 [{:type :computer} {:type :human}]
   :4 [{:type :computer} {:type :computer}]})

(defn get-choice [input]
  ((keyword input) players))
