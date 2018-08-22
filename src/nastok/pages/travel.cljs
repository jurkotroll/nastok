(ns nastok.pages.travel
  (:require
    [re-frame.core :refer [subscribe dispatch]]
    ["@material-ui/core/List" :default List]
    ["@material-ui/core/ListItem" :default ListItem]
    ["@material-ui/core/ListItemText" :default ListItemText]
    [reitit.frontend.easy :as rfe]
    ["@material-ui/core/Avatar" :default Avatar]
    ["@material-ui/core/Button" :default Button]
    [fipp.edn :as fedn]))

; (defn travelid [match]
;  (let [{:keys [path query]} (:parameters match)
;        {:keys [id]} path]
;        ;travels (subscribe [:travels])]
;        ;travel (get travels id)]
;        ;{:keys [travel/id travel/place]} travel]
;
;    (fn []
;      [:div
;       [:h1 (str "Travel" id)]
;       [:> Button {:on-click #(rfe/push-state :travels/listpage)} "Back"]
;       [:pre (with-out-str (fedn/pprint @match))]])))

(defn travelid [match]
 (let [{:keys [path query]} (:parameters match)
       {:keys [id]} path]
  (fn []
   [:div
    [:h1 (str "id: " id)]])))
