(ns viterbi.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

  ;wordSquence = (hash-map word (hash-map POS probability))
  (defn tracer
    "implementation of the viterbi-algorithm"
   [posMap, biGramMap, wordSequence]
   (if (contains? wordSequence "<\\s>")
    wordSequence
   )
  )

  (defn maxVal
    [priMapVa, biMapVal]
    (max (map (* )))
    )

  (flatten (map (fn [innereH] (vals innereH)) (vals (hash-map "mein" (hash-map "hund" 12,
  "kaninchen" 13), "deine" (hash-map "kuh" 14, "katze" 15)))))
