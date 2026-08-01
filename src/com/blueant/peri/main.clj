(ns com.blueant.peri.main
  "Runs the com.blueant/peri service."
  (:require [io.pedestal.connector :as connector]
            [io.pedestal.log :as log]
            [io.pedestal.http.http-kit :as hk]
            [com.blueant.peri.connector :refer [connector-map]]))

(defn- log-startup
  [connector-map]
  (log/info :msg "Service com.blueant/peri startup"
            :port (:port connector-map))
  connector-map)

(defn start-service
  [_]
  (-> (connector-map {:join? true})
      log-startup
      (hk/create-connector nil)
      connector/start!))

