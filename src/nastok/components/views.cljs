(ns nastok.components.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [reagent.core :as r]
            [nastok.components.travelpage :as travelpage]
            [nastok.components.listspage :as listpage]
            [nastok.components.frontpage :as frontpage]
            [nastok.theme :refer [theme]]

            ["@material-ui/core/Paper" :default Paper]
            ["@material-ui/core/Card" :default Card]
            ["@material-ui/core/CardContent" :default CardContent]
            [cljs-css-modules.macro :refer-macros [defstyle]]
            [oops.core :refer [ocall oget oset!]]))


(js/console.log ".palette.background.paper " (oget theme ["palette" "background" "paper"]))
(js/console.log ".spacing.unit " (oget theme ["spacing" "unit"]))

; (let [up-func (oget @localtheme ["breakpoints" "up"])
;       queries (up-func 600)]
;   (when (string? queries) (js/console.log (str "queries " queries))))
;
;
;
(let [;theme (subscribe [:get-theme])
      unit-background-color (oget theme ["palette" "background" "paper"])
      spacing-unit (oget theme ["spacing" "unit"])
      content-padding (str
                       (* spacing-unit 8)
                       "px 0 "
                       (* spacing-unit 6)
                       "px 0")
      layout-magrin-left (str (* spacing-unit 3))
      layout-magrin-right (str (* spacing-unit 3))
      card-grid-padding (str (* spacing-unit 8) "px 0")]
      ;layout-queri-min-width (str (+ 1100 (* spacing-unit 3 2)) "px")]

  (defstyle styles
     [".heroUnit" {:background-color unit-background-color}] ;}]
     [".heroContent" {:max-width "600px"
                      :margin "0 auto"
                      :padding content-padding}]
     [".layout" {:width "auto"
                 :margin-left layout-magrin-left
                 :margin-right layout-magrin-right}]
                 ; (at-media {:min-width layout-queri-min-width} [:width 1100
                 ;                                                :margin-left "auto"
                 ;                                                :margin-right "auto"]) true}]
     [".cardGrid" {:padding card-grid-padding}]))


(defn travelid [] ;;=====> views
  (let []
    [:> Paper
     [:> Card
       [:> CardContent
         [travelpage/info-block-main]]]]))

(defn travels-page []
  (let []
    (fn []
      [:div.view
        [:h1 "Travels"]
        [listpage/list-of-travels]])))

(defn frontpage []
  (fn []
    [:main
     [:div ;{:class-name (:hero-unit styles)}
      [:div ;{:class-name (:hero-content styles)}
       [frontpage/toptext]
       [frontpage/buttons]]]]))
     ;[:div {:class-name (:album-of-cards styles)}]]))
