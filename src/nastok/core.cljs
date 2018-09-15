(ns nastok.core
  (:require
   [nastok.db.handlers]
   [nastok.db.subs]
   [reagent.core :as r]
   [reagent.session :as session]
   [re-frame.core :refer [subscribe dispatch dispatch-sync]]
   [oops.core :refer [ocall oget oset!]]

   [nastok.fb.init :refer [firebase-init]]
   [nastok.pages.routs :as pages.routs]

   ["@material-ui/core/styles" :refer [MuiThemeProvider createMuiTheme]]
   ["@material-ui/core/colors/cyan" :default cyanColor]))

(def theme (createMuiTheme (clj->js {:palette {:primary {:light (oget cyanColor "400")
                                                         :main (oget cyanColor "600")
                                                         :dark (oget cyanColor "900")
                                                         :contrastText "#fff"}}})))
(defn app []
  (let [user (subscribe [:user])]
    (fn []
      [:> MuiThemeProvider
       {:theme theme}
       (if @user
         [pages.routs/main-component])])))

(defn render []
  (r/render [app]
            (js/document.getElementById "app")))

(defn on-window-resize []
  (dispatch [:window-width (oget js/window "innerWidth")]))

(defn ^:export init []
  (dispatch-sync [:initialize])
  (firebase-init)
  (pages.routs/init-routs)
  (render)
  (ocall js/window "addEventListener" "resize" on-window-resize))
