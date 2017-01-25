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

 ;keyWords: Liste von Wörtern, priMapVa: hash-map mit wörtern und POS
 ;biMapVal: hash-map mit POS und POS, maximum: das bisherige größte Wort
  (defn maxVal
    [keyWords, priMapVa, biMapVal, maximum]
    (if (empty? keyWords)
     maximum
       (let [newMax (hash-map (first keyWords)
                   (into (hash-map) (apply max-key val (merge-with * (get priMapVa (first keyWords)) biMapVal))))]
       (if (newMax > (val (first (val (first maximum)))))
         (maxVal (rest keyWords), priMapVa, biMapVal, newMax)
         (maxVal (rest keyWords), priMapVa, biMapVal, maximum))
       )
     )
    )

   (defn filterHashMap
    "filter all pos-tags that are needed in every hash-map from a word"
    [keyWords, hashMapWord, keyPOS]
     (if (empty? keyWords)
      hashMapWord
      (let [newWordMapPOS (assoc hashMapWord (first keyWords) (select-keys (get hashMapWord (first keyWords)) keyPOS))]
       (if (= (get newWordMapPOS (first keyWords)) {})
       (filterHashMap (rest keyWords), (dissoc newWordMapPOS (first keyWords)), keyPOS)
       (filterHashMap (rest keyWords), newWordMapPOS, keyPOS))
       )
     )
    )

  ;  (maxVal '("geschickt", "werden"), (hash-map "geschickt" (hash-map "Part" 0.4), "werden" {"AuxV" 0.3, "KopV" 0.5}},
  ;   (hash-map "AuxV" 0.4 "KopV" 0.3 "Part" 0.1), 0)

    (filterHashMap '("wir" "werden" "geschickt") (hash-map "wir" (hash-map "Nomn" 0.2)
     "werden" (hash-map "AuxV" 0.3 "KopV" 0.5) "geschickt" (hash-map "Adje" 0.2 "Part" 0.4))
     '("AuxV" "KopV" "Part"))
