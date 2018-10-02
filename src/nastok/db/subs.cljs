(ns nastok.db.subs
  (:require [re-frame.core :as rf]
            [oops.core :refer [ocall oget]]
            [cljs-time.core :as time]
            [cljs-time.format :as timef]))

(rf/reg-sub
 :user
 (fn
   [db _]
   (:user db)))

(rf/reg-sub
 :window-width
 (fn
   [db _]
   (:window-width db)))

(rf/reg-sub
 :travels
 (fn
   [db _]
   (:travels db)))

(rf/reg-sub
 :travel
 (fn [db _]
  (let [id @(rf/subscribe [:travel-id])]
   (get-in db [:travels id] (str "no travel with id" id)))))

(rf/reg-sub
  :get-match
  (fn [db _]
    (:match db)))

(rf/reg-sub
  :get-view-from-match
  (fn [db _]
    (get-in db [:match :data :view])))



(rf/reg-sub
  :travel-id
  (fn [db _]
    (get-in db [:match :path-params :id])))

(rf/reg-sub
  :day-of-week
  (fn [db _]
    (let [travel @(rf/subscribe [:travel])
          date (:travel/date travel)]
       date)))
