(ns com.blueant.peri.telemetry-init
  (:require [io.pedestal.metrics.otel :as otel])
  (:import (io.opentelemetry.api GlobalOpenTelemetry)))

(defn metric-source
  "Wraps the meter obtained from GlobalOpenTelemetry, with an
  instrumentation scope name of com.blueant.peri.metrics."
  []
  (-> (GlobalOpenTelemetry/getMeter "com.blueant.peri.metrics")
      (otel/wrap-meter)))

(defn tracing-source
  "Returns the tracer obtained from GlobalOpenTelementry, with an
  instrumentation scope name of com.blueant.peri.tracing."
  []
  (GlobalOpenTelemetry/getTracer "com.blueant.peri.tracing"))
