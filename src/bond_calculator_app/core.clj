(ns bond-calculator-app.core
  (:require [com.stuartsierra.component :as component]
            [bond-calculator-app.server :as s]
            [taoensso.timbre :as timbre :refer [log  trace  debug  info  warn  error  fatal  report
                                                logf  tracef debugf infof warnf errorf fatalf reportf
                                                spy get-env]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;

(def system (atom nil))

(def config {:port 5000 :thread 4})

(defn init [config]
  (component/system-map
   :server (s/new-server config)))

(defn start []
  (let [start (component/start (init config))]
        (timbre/info "Starting server on port: 5000")
        (reset! system start)))

 (defn shutdown []
    (timbre/info "Shutting down http-kit server on port: 5000" )
    (component/stop @system)
    (reset! system nil)
    (timbre/info "App shutdown."))
