(ns grade-school)

(defn add [db name grade]
  (update-in db [grade] concat [name]))

(defn grade [db grade]
  (get db grade []))

(defn sorted [db]
  (reduce-kv (fn [m k v]
               (assoc m k (sort v)))
             (sorted-map) db))
