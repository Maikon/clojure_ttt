(ns tic_tac_toe.board)

(declare rows columns diagonals
         position-available? lines all-equal-not-empty
         moves-made)

(defn new-board
  ([] (vec (take 9 (repeat ""))))
  ([size] (vec (take (* size size) (repeat "")))))

(defn mark-position [board position mark]
  (if (position-available? board position)
    (assoc board position mark)
    board))

(defn winner?
  ([board] (->> (lines board)
                (map (partial all-equal-not-empty))
                (some true?)))

  ([board mark] (->> (lines board)
                     (map (partial all-equal-not-empty mark))
                     (some true?))))

(defn rows [board]
  (partition
    (int (Math/sqrt (count board)))
    board))

(defn available-moves [board]
  (filter number?
          (flatten (filter #(empty? (% 1))
                           (map-indexed vector board)))))

(defn over? [board]
  (or (winner? board) (empty? (available-moves board))))

(defn current-mark [board]
    (if (even? (mod (moves-made board) 2))
    "x"
    "o"))

(defn- moves-made [board]
  (- (count board) (count (available-moves board))))

(defn- position-available? [board position]
  (let [pos (get board position)]
    (and pos (empty? pos))))

(defn- lines [board]
  (apply concat (list (rows board) (columns board) (diagonals board))))

(defn- all-equal-not-empty
  ([line] (and (not (every? empty? line)) (apply = line)))
  ([mark line] (apply = mark line)))

(defn- columns [board]
  (apply map list (rows board)))

(defn- diagonals [board]
  (let [r (range (count (rows board)))]
    (concat
      (vector (map #(nth %1 %2) (rows board) r))
      (vector (map #(nth %1 %2) (rows board) (reverse r))))))
