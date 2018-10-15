(ns nastok.routing
  (:require
     [reitit.frontend.easy :as rfe]
     [reitit.core :as re]
     [nastok.components.top :as components.top]
     [nastok.components.views :as components.views]
     [nastok.components.manemenu :as components.manemenu]
     [nastok.theme :refer [theme]]
     [reitit.coercion :as rc]
     [reitit.coercion.schema :as rsc]
     [schema.core :as s]
     [reagent.core :as r]
     [re-frame.core :refer [subscribe dispatch dispatch-sync]]
     [schema.core :as s]
     [fipp.edn :as fedn]))


;(defonce match (r/atom nil))

(defn my-profile []
  (let [user (subscribe [:user])]
    [:div
     [:h1 "Email"]
     [:h2 (get-in @user [:email])]]))

(defn about-page []
  [:div
   [:h2 "About frontend"]
   [:ul
    [:li [:a {:href "http://google.com"} "external link"]]
    [:li [:a {:href (rfe/href ::foobar)} "Missing route"]]
    [:li [:a {:href (rfe/href ::item)} "Missing route params"]]]])

(defn pageview
 [match]
 (if match
   (let [view (get-in match [:data :view])]
    ;[:div "test"]
    [view])))


(defn main-component []
  (let [match (subscribe [:get-match])]
        ;theme (subscribe [:get-theme])]

    (fn []
      [:div
       ;[:div "test"]
       [components.top/bar]
       [components.manemenu/menu]
       [pageview @match]
       [:pre (with-out-str (fedn/pprint @match))]
       [:pre (with-out-str (fedn/pprint theme))]])))



(def routes
  (re/router
    ["/"

     ["travels"
      {:name :travels/listpage
       :view components.views/travels-page}]
     ["travel/:id"
      {:name :travels/travel
       :view components.views/travelid
       :parameters {:path {:id s/Str}}}]
                    ;:query {(s/optional-key :foo) s/Keyword}}}]
     [""
      {:name :website/frontpage
       :view components.views/frontpage}]
     ["about"
      {:name :website/about
       :view about-page}]
     ["profile"
      {:name :users/my-profile
       :view my-profile}]]
    {:compile rc/compile-request-coercers
     :data {:coercion rsc/coercion}}))

(defn init-routes []
  (rfe/start! routes
              ;(fn [m] (reset! match m))
              (fn [m] (dispatch [:update-match m]))
              {:use-fragment true
               :path-prefix "/"}))
