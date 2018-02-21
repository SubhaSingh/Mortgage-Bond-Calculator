(ns bond-calculator-app.query
  (:require [datomic.api :as d]
            [clojure.math.numeric-tower :as m]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;
(def  uri "datomic:free://localhost:4334/bondCalculations")

(def conn (d/connect uri))

(def db (d/db conn))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Helpers
(defn roundto
  "Round a double to the given precision (number of significant digits)"
  [precision d]
  (let [factor (Math/pow 10 precision)]
    (/ (Math/round (* d factor)) factor)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Calculations


(defn monthly-repayment [purchase-price deposit term interest-rate]
  (let [interest (/ (/ interest-rate 12) 100)
        months (* term 12)
        amount (- purchase-price deposit)
        base (+ 1 interest)]
    (/ (* (* interest amount) (m/expt (double base) months)) (- (m/expt (double base) interest) 1))))

(comment

  (monthly-repayment 200000 50000 5 5)

  )

(defn save-calculation [])
