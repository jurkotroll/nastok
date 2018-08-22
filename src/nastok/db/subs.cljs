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
