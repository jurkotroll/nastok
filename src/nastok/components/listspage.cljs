(ns nastok.components.listspage
  (:require
    [re-frame.core :refer [subscribe dispatch]]
    ["@material-ui/core/List" :default List]
    ["@material-ui/core/ListItem" :default ListItem]
    ["@material-ui/core/ListItemText" :default ListItemText]
    ["@material-ui/core/ListItemSecondaryAction" :default ListItemSecondaryAction]
    [reitit.frontend :as rf]
    [reitit.frontend.easy :as rfe]
    [reitit.frontend.history :as rfh]
    ["@material-ui/core/Avatar" :default Avatar]
    #_["@material-ui/core/Link" :default Link]
    ["@material-ui/core/ButtonBase" :default ButtonBase]
    ["@material-ui/core/Button" :default Button]

    [fipp.edn :as fedn]))

(enable-console-print!)



(defn travel-to-list [id place]
  (let [open-travel #(rfe/push-state :travels/travel {:id id})]

     [:> ListItem {:button true :divider true :on-click open-travel} ;;:key id

      [:> Avatar (first place)]
      [:> ListItemText {:primary place}]
      [:a {:href nil}
       [:> ListItemSecondaryAction
        [:> Button "Open"]]]]))





(defn list-of-travels []
  (let [travels (subscribe [:travels])
        values (vals @travels)]
    [:> List {:subheader "Travels"}
      (for
        [{:keys [travel/id travel/place]} values]
        ^{:key id} [travel-to-list id place])]))
