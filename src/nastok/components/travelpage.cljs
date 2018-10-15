(ns nastok.components.travelpage
    (:require
      [re-frame.core :refer [subscribe dispatch]]
      ["@material-ui/core/Paper" :default Paper]
      ["@material-ui/core/Card" :default Card]
      ["@material-ui/core/CardContent" :default CardContent]
      ["@material-ui/core/Grid" :default Grid]
      ["@material-ui/core/Typography" :default Typography]
      ["@material-ui/core/Hidden" :default Hidden]
      ["@material-ui/core/List" :default List]
      ["@material-ui/core/ListItem" :default ListItem]
      ["@material-ui/core/ListItemText" :default ListItemText]
      [reitit.frontend.easy :as rfe]
      ["@material-ui/core/Avatar" :default Avatar]
      ["@material-ui/core/Button" :default Button]
      [fipp.edn :as fedn]
      [reagent.core :as r]))

(defn info-block-main []  ;;=====> components
  (let [travel (subscribe [:travel])]
    [:> Grid {:container true
              :spacing 8
              :style {:display "flex" :justify-content "space-between"}} ;;main information block: when&where
     [:> Grid {:item true :xs 12 :sm 6 :md 4
               :style {:padding "10px 0px 10px 20px"}} ;; information  when?
      [:> Typography {:color "textSecondary" :variant "title" :align "left" :gutterBottom true}
        "kiedy?"]
      [:> Typography {:color "primary" :variant "h5"}
        (str (:travel/date @travel))]]
     [:> Hidden {:xlDown true}]
     [:> Grid {:item true :xs 12 :sm 6 :md 4
               :style {:display "flex"
                       :flex-direction "column"
                       :justify-content "flex-start"
                       :padding "10px 20px 10px 0px"}} ;; information  where?
      [:> Typography {:color "textSecondary" :variant "title" :align "right" :gutterBottom true}
        "where?"]
      [:> Typography {:color "primary" :variant "display1" :align "right"  :style {:flex-grow 2}}
        (str (:travel/place @travel))]]]))
