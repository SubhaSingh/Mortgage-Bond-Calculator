(ns bond-calculator-app.server
  (:require [org.httpkit.server :as http-kit]
            [compojure.route :as route]
            [compojure.handler :as handler] ; form, query params decode; cookie; session, etc
            [compojure.core :refer (defroutes GET POST)]
            [ring.util.response :refer [redirect]]
            [ring.middleware.cors :refer [wrap-cors]]
            [ring.middleware.reload :as reload]
            [bond-calculator-app.calculation :as c]
            [com.stuartsierra.component :as component]
            [taoensso.timbre :as timbre :refer [log  trace  debug  info  warn  error  fatal  report
              logf tracef debugf infof warnf errorf fatalf reportf
              spy get-env]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;Handlers

(defn save-calculation-handler [req]
  (let [params (:params req)
       ;; purchase-price (:params purchase-price)
       ;; deposit (:params deposit)
       ;; term (:params term)
        ;; interest-rate (:params interest-rate)
        ]
    (println params)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Routes

(defroutes routes
  (GET "/" [] (redirect "/home.html"))
  (POST "/saveCalculation" request (save-calculation-handler request))
  (route/resources "/")
  (route/not-found "Page not found"))

(def application (-> (handler/site routes)
                     reload/wrap-reload
                     (wrap-cors
                      :access-control-allow-origin #".+")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Server component
(defrecord httpKitWebServer [config]
  component/Lifecycle
  (start [component]
    (timbre/info "Starting web server component.")
    (let [instance  (http-kit/run-server application config)]
          (assoc component :http-server instance)))
  (stop [component]
    (timbre/info "Stopping web server component.")
    (let [stop-fn (:http-server component)]
      (stop-fn)
      (dissoc component :http-server))))

(defn new-server [config]
  (->httpKitWebServer config))

(comment

  (def app (component/start (new-server {:port 6000 :thread 8})))

  (component/stop app)
  )
