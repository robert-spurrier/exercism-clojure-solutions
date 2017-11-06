(ns nucleotide-count)

(defn dna? [x]
  (char? (#{\A \T \C \G} x)))

(defn nucleotide-counts [x]
  (merge
   {\A 0 \T 0 \C 0 \G 0}
   (frequencies x)))

(defn count [x s]
  {:pre [(dna? x)]}
  (get (nucleotide-counts s) x 0))



