(ns tic_tac_toe.colorize
  "This code is from the following repo: https://github.com/ibdknox/colorize
  which I could not bring in its entirety since it was causing
  multiple issues with the codebase.")

(def ansi-colors {:reset "[0m"
                  :default "[39m"
                  :red     "[31m"
                  :green   "[32m"})

(defn ansi
  "Get the ansi code for a specific color"
  [code]
  (str \u001b (get ansi-colors code (:reset ansi-colors))))

(defmacro create-colors []
  (apply list 'do
         (for [k (keys ansi-colors)]
           (let [code (ansi k)
                 reset (ansi :reset)]
             `(defn ~(symbol (name k)) [& s#]
                (str ~code (apply str s#) ~reset))))))

(create-colors)

