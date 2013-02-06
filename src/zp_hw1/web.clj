(ns zp-hw1.web
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:use [ring.middleware.reload :only [wrap-reload]])
  (:use [clojure.string :only [split]])
  (:use [zp-hw1.mats :only [addz subz multz]]))

(defn parseargs [req]
	(map read-string (split ((split (req :query-string) #"=") 1) #",")))

(defn respond [req]
	(case (req :uri)
		"/" "THIS IS NOT A HOMEPAGE!"
		"/add" (str (apply addz (parseargs req)))
		"/subtract" (str (apply subz (parseargs req)))
		"/multiply" (str (apply multz (parseargs req))))
)

(defn app [req]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (respond req)})


(defn -main [port]
  (run-jetty (wrap-reload app) {:port (Integer. port)}))