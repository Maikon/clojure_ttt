(ns tic_tac_toe.board)

(declare rows columns diagonals)

(defn new-board
  ([] (vec (range 0 9)))
  ([size] (vec (range 0 (* size size)))))

(defn mark-position [board position mark]
  (if (get board position)
    (assoc board position mark)
    (throw (Exception. "Invalid Move"))))

(defn winner? [board]
  (some true?
        (map #(apply = %)
             (apply concat (list (rows board) (columns board) (diagonals board))))))

(defn rows [board]
  (partition
    (int (Math/sqrt (count board)))
    board))

(defn available-moves [board]
  (filter number? board))

(defn over? [board]
  (or (winner? board) (empty? (available-moves board))))

(defn- columns [board]
  (apply map list (rows board)))

(defn- diagonals [board]
  (let [r (range (count (rows board)))]
    (concat
    (vector (map #(nth %1 %2) (rows board) r))
    (vector (map #(nth %1 %2) (rows board) (reverse r))))))
