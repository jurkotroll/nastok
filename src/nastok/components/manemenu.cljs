(ns nastok.components.manemenu
  (:require
    [reitit.frontend.easy :as rfe]))

(defn menu []
 [:ul {:style {:margin-top "100px"}}
  [:li [:a {:href (rfe/href :website/frontpage)} "Frontpage"]]
  [:li [:a {:href (rfe/href :travels/listpage)} "List of travels"]]
  [:li [:a {:href (rfe/href :travels/travel {:id "travel001"})} "Travel001"]]
  [:li [:a {:href (rfe/href :travels/travel {:id "travel002"})} "Travel002"]]
  [:li [:a {:href (rfe/href :website/about)} "About"]]
  [:li [:a {:href (rfe/href :users/my-profile)} "My Profile"]]])
