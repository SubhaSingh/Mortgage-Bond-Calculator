(ns bond-calculator-app.calculation
  (:require [datomic.api :as d]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;
(def  uri "datomic:free://localhost:4334/bondCalculations")

(def conn (d/connect uri))

(def db (d/db conn))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;

(defn save-calculation [params]
  (let [purchase-price    (:purchase_price params)
        deposit           (:deposit params)
        term              (:term params)
        interest-rate     (:interest_rate params)
        monthly-repayment (:monthly_repayment params)
        fullname          (:fullname params)
        email             (:email params)]
    (d/transact conn  [(hash-map :db/id (d/tempid :calculations)
                                 :user/user-fullname fullname
                                 :user/email email
                                 :calculation/purchase-price (Double/valueOf  purchase-price)
                                 :calculation/deposit (Double/valueOf deposit)
                                 :calculation/term (Double/valueOf term)
                                 :calculation/interest-rate (Double/valueOf interest-rate)
                                 :calculation/monthly-repayment  (Double/valueOf monthly-repayment))])))
