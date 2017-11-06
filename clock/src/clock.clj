(ns clock)

(defrecord Clock [hour minute])

(defn rollover [m]
  (cond
    (>= m 60) (int (/ m 60))
    (< m 0) (- (int (/ m 60)) 1)
    :default 0))
  
(defn clock [hour minute]
  (let [minute-remainder (mod minute 60)
        rollover-hours (rollover minute)
        total-hour (mod (+ hour rollover-hours) 24)]
    (->Clock total-hour minute-remainder)))

(defn clock->string [c]
  (str (format "%02d" (:hour c))
       ":"
       (format "%02d" (:minute c))))

(defn add-time [c minutes]
  (let [old-minutes (+ (:minute c)
                       (* (:hour c) 60))]
    (clock 0 (+ minutes old-minutes))))
