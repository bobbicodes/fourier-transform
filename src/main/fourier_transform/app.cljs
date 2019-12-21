(ns fourier-transform.app
  (:require [reagent.core :as r]))

(def xs (range 500))

(def t (r/atom 0))

(defn points []
  (for [x (range 500)]
    [x (+ 200 (* 20 (.sin js/Math (/ (+ x @t) 10))))]))

(defn path [[x y]]
  (str x "," y " "))

(comment
  (points)
  (str "M" (apply str (interpose "L" (map path (points))))))
  
  

(defn animate! []                
    (.setAttribute (.querySelector js/document "path") "d"
                   (str "M" (apply str (interpose "L" (map path (points))))))
    (swap! t #(+ 0.5 %))
    (js/requestAnimationFrame animate!))

(defn app
  []
  [:div.container
   [:svg {:width  "600px"
          :height "400px"}
    [:path {:stroke "#00FF00" :fill "none" :d "M10 80 C 40 10, 65 10, 95 80 S 150 150, 180 80 Z"}]]])

(defn ^:export init
  []
  (r/render
   [app]
   (.getElementById js/document "root"))
  (animate!)
  )

(defn ^:dev/after-load start []
  (js/console.log "start")
  (init))

(comment
  
  (range 500)

  )