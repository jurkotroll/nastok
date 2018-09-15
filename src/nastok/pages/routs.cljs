(ns nastok.pages.routs
  (:require
     [reitit.frontend.easy :as rfe]
     [reitit.core :as re]
     [nastok.pages.frontpage :as pages.frontpage]
     [nastok.pages.travels :as pages.travels]
     [nastok.pages.travel :as pages.travel]
     [nastok.components.top :as components.top]
     [nastok.components.views :as components.views]
     [nastok.components.manemenu :as components.manemenu]
     [reitit.coercion :as rc]
     [reitit.coercion.schema :as rsc]
     [schema.core :as s]
     [reagent.core :as r]
     [re-frame.core :refer [subscribe dispatch dispatch-sync]]
     [schema.core :as s]
     [fipp.edn :as fedn]))


(defonce match (r/atom nil))

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

(defn item-page [match]
  (let [{:keys [path query]} (:parameters match)
        {:keys [id]} path]
    [:div
     [:h2 "Selected item " id]
     (if (:foo query)
       [:p "Optional foo query param: " (:foo query)])]))




(defn pageview
 [match1]
 (if match1
   (let [view (:view (:data match1))]

    [view match1])))


(defn main-component []
  (let []
    (fn []
      [:div
       [components.top/bar]
       [components.manemenu/menu]
       [pageview @match]
       [:pre (with-out-str (fedn/pprint @match))]])))



(def routes
  (re/router
    ["/"

     ["travels"
      {:name :travels/listpage
       :view pages.travels/travels-page}]
     ["travel/:id"
      {:name :travels/travel
       :view pages.travel/travelid
       :parameters {:path {:id s/Str}
                    :query {(s/optional-key :foo) s/Keyword}}}]
     [""
      {:name :website/frontpage
       :view pages.frontpage/frontpage}]
     ["about"
      {:name :website/about
       :view about-page}]
     ["profile"
      {:name :users/my-profile
       :view my-profile}]]
    {:compile rc/compile-request-coercers
     :data {:coercion rsc/coercion}}))

(defn init-routs []
  (rfe/start! routes
              (fn [m] (reset! match m))
              {:use-fragment true
               :path-prefix "/"}))
