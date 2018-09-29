(ns nastok.db.handlers
  (:require [re-frame.core :as rf]
            [oops.core :refer [ocall oget]]
            [nastok.fb.db :as firebase-db]
            [re-frame.core :refer [dispatch]]
            ["uuid" :as random]))

(def empty-db
  {:window-width (oget js/window "innerWidth")
   :user {}
   ;:match nil
   :travels {"travel001" #:travel{:id "travel001"
                                  :place "Jańskie Łaźnie"
                                  :date "20-01-2019"
                                  :start-city "Wrocław"
                                  :start-time "6:00"}
             "travel002" #:travel{:id "travel002"
                                  :place "Czarna Góra"
                                  :date "27-01-2019"
                                  :start-city "Wrocław"
                                  :start-time "6:00"}
             "travel003" #:travel{:id "travel003"
                                  :place "Pec"
                                  :date "28-01-2019"
                                  :start-city "Wrocław"
                                  :start-time "6:00"}
             "travel004" #:travel{:id "travel004"
                                  :place "Roketnice"
                                  :date "31-01-2019"
                                  :start-city "Wrocław"
                                  :start-time "6:00"}}})

(rf/reg-event-db
 :update-match
 (fn
   [db [_ match]]
   (assoc db :match match)))


(rf/reg-event-db
 :update-user
 (fn
   [db [_ user]]
   (let [user-details {:name (:name user)
                       :email (:email user)
                       :photo (:photo user)}]
     (firebase-db/save! (str "users/" (:uid user)) (clj->js user-details))
     (assoc db :user user))))

(rf/reg-event-db
 :set-anonymous-user
 (fn
   [db _]
   (assoc db :user {})))

(rf/reg-event-db
 :initialize
 (fn
   [_ _]
   empty-db))

(rf/reg-event-db
 :sign-out
 (fn
   [db _]
   (assoc db :user {})))

(rf/reg-event-db
 :window-width
 (fn [db [_ window-width]]
   (assoc db :window-width window-width)))
