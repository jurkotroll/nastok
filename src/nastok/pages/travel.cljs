(ns nastok.pages.travel
  (:require
    [re-frame.core :refer [subscribe dispatch]]
    ["@material-ui/core/List" :default List]
    ["@material-ui/core/ListItem" :default ListItem]
    ["@material-ui/core/ListItemText" :default ListItemText]
    [reitit.frontend.easy :as rfe]
    ["@material-ui/core/Avatar" :default Avatar]
    ["@material-ui/core/Button" :default Button]
    [fipp.edn :as fedn]
    [reagent.core :as r]))

(defn travelid1 [match]
 (fn []
   (let [id-from-match #(:id (:path (:parameters match)))
         {:keys [id]} (:path (:parameters match))
         travel (subscribe [:travel (id-from-match)])]
    [:div
     [:pre (with-out-str (fedn/pprint (id-from-match)))]
     [:pre (with-out-str (fedn/pprint match))]
     [:pre (with-out-str (fedn/pprint @travel))]
     ;[:h1 (str "path " path)]
     [:h1 (str "id: " id)]])))

(defn travelid2 [match]
 (let [;id-from-match #(:id (:path (:parameters @match)))
       {:keys [id]} (:path (:parameters match))]
       ;travel (subscribe [:travel (id-from-match)])]

   (fn [] ;; <-- tu =====
    [:div
     ;[:pre (with-out-str (fedn/pprint (id-from-match)))]
     [:pre (with-out-str (fedn/pprint match))]
     ;[:pre (with-out-str (fedn/pprint @travel))]
     ;[:h1 (str "path " path)]
     [:h1 (str "id: " id)]])))

(defn travelid3 [match]
 (let [;id-from-match #(:id (:path (:parameters match)))
       {:keys [id]} (:path (:parameters match))]
       ;travel (subscribe [:travel (id-from-match)])]

   (fn [match] ;; <-- tu =====
    [:div
     ;[:pre (with-out-str (fedn/pprint (id-from-match)))]
     [:pre (with-out-str (fedn/pprint match))]
     ;[:pre (with-out-str (fedn/pprint @travel))]
     ;[:h1 (str "path " path)]
     [:h1 (str "id: " id)]])))

(enable-console-print!)

(defn travelid
  [match]
  (let [mid (:id (:path (:parameters match)))
        travel (subscribe [:travel mid])
        maptr @travel
        upinmaptr (r/atom (assoc-in maptr [:travel/place] "LOLOLOL"))]
    (r/create-class
      {:component-did-mount
       (fn []
         (println "did mount")
         (println (str "mid " mid))
         (println (str "id from match " (:id (:path (:parameters match)))))
         (println (str maptr))
         (println (str @upinmaptr)))
       :display-name "travelid"
       :component-will-update
       (fn [this [_ props]]
        ;(let [{:keys [id]} (:path (:parameters props))]
         (println (str "mid " mid))
         (println (str "props " props))
         (println (str "will update " (:id (:path (:parameters props)))))
         (println (str @upinmaptr))
         (reset! upinmaptr @(subscribe [:travel (:id (:path (:parameters props)))]))
         (println (str @upinmaptr)))
       :reagent-render
       (fn [match] ;; <-- tu =====
        [:div
         ;[:pre (with-out-str (fedn/pprint (id-from-match)))]
         ;[:pre (with-out-str (fedn/pprint match))]
         [:pre (with-out-str (fedn/pprint @upinmaptr))]
         ;[:h1 (str "path " path)]
         [:h1 (str "id: " (:travel/id @upinmaptr))]])})))
