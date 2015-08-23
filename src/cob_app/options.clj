(ns cob-app.options
  (:require [cob-app.core :refer [pre-route]]))

(defmethod pre-route ["OPTIONS" "/method_options"] [_ _]
  ["HTTP/1.1 200 OK\r\n"
   "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n\r\n"])

