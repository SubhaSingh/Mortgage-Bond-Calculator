(ns bond-calculator-app.calculation
  (:require [datomic.api :as d]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;
(def  uri "datomic:free://localhost:4334/bondCalculations")

(def conn (d/connect uri))

(def db (d/db conn))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;

(defn save-calculation []
  )
