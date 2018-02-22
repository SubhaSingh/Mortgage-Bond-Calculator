(defproject bond_calculator_app "0.1.0-SNAPSHOT"
  :description "Bond Calculation Web App"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.datomic/datomic-free "0.9.5656"]
                 [http-kit "2.2.0"]
                 [ring "1.6.0" :exclusions [commons-codec]]
                 [ring-cors "0.1.10" :exclusions [commons-codec]]
                 [compojure "1.6.0" :exclusions [commons-codec]]
                 [com.stuartsierra/component "0.3.2"]
                 [com.taoensso/timbre "4.10.0"]]
  :main ^:skip-aot bond-calculator-app.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
