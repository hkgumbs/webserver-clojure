(ns webserver.mock-socket
  (:require [webserver.app :as app]))

(defn make [input]
  (let [ouput-stream (java.io.ByteArrayOutputStream.)]
    (proxy [java.net.Socket]
      []
      (getInputStream [] (java.io.ByteArrayInputStream. (.getBytes input)))
      (getOutputStream [] ouput-stream))))

(defn connect
  ([request]
   (connect request ""))
  ([request body]
   (let [socket (make body)]
     (app/handle socket request)
     (str (.getOutputStream socket)))))

