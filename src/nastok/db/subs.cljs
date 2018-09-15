(ns nastok.db.subs
  (:require [re-frame.core :as rf]
            [oops.core :refer [ocall oget]]))

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
 (fn [db [_ id]]
  (get-in db [:travels id] (str "no travel with id" id))))
