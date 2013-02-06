(ns zp-hw1.web
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:use [clojure.string :only [split]])
  (:use [zp-hw1.mats :only [addz subz multz]]))

(defn respond [req]
	(let
		[args (map read-string (split ((split (req :query-string) #"=") 1) #","))]
			(case (req :uri)
				"" "THIS IS NOT A HOMEPAGE!"
				"/add" (str (apply addz args))
				"/subtract" (str (apply subz args))
				"/multiply" (str (apply multz args))))
)

(defn app [req]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (respond req)})


(defn -main [port]
  (run-jetty app {:port (Integer. port)}))