(ns fourier-transform.app
  (:require [reagent.core :as r]
            [clojure.string :as str]))

(defn app
  []
  [:div.container
   [:svg {:width    "190px"
          :height   "160px"
}
    [:path {:stroke "#00FF00" :fill "none" :d "M10 80 C 40 10, 65 10, 95 80 S 150 150, 180 80 Z"}]]])

(defn ^:export init
  []
  (r/render
   [app]
   (.getElementById js/document "root")))

(defn ^:dev/after-load start []
  (js/console.log "start")
  (init))

(comment
  
  (loop [a 0]
    (println (str/join (repeat (int (+ 20 (* 20 (.sin js/Math a)))) " ")))
    (recur (+ a 0.1)))

  )