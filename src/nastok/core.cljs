(ns nastok.core
  (:require
   [clojure.browser.repl :as repl]
   [nastok.db.handlers]
   [nastok.db.subs]
   [reagent.core :as r]
   [reagent.session :as session]
   [re-frame.core :refer [subscribe dispatch dispatch-sync]]
   [oops.core :refer [ocall oget oset!]]

   [nastok.fb.init :refer [firebase-init]]
   [nastok.routing :as routes]
   [nastok.theme :refer [theme]]

   ["@material-ui/core/styles" :refer [MuiThemeProvider createMuiTheme]]
   ["@material-ui/core/colors/cyan" :default cyanColor]
   ["@material-ui/core/colors/purple" :default purpleColor]
   ["@material-ui/core/colors/red" :default redColor]))

;;(repl/connect "http://localhost:9000/repl")

(enable-console-print!)

; (def theme (createMuiTheme (clj->js {:palette
;                                              {:primary {:light (oget cyanColor "400")
;                                                         :main (oget cyanColor "600")
;                                                         :dark (oget cyanColor "900")
;                                                         :contrastText "#fff"}
;                                                 ;{}
;                                                  ; :primary {;:light (oget purpleColor "100")
;                                                  ;           :main (oget purpleColor "300")
;                                                  ;           ;:dark (oget purpleColor "600")
;                                                  ;           :contrastText (.-getContrastText (oget purpleColor "300"))}
;                                                  :secondary {;:light (oget cyanColor "700")
;                                                              :main (oget cyanColor "800")}}
;                                                  ;:type "light"}
;                                                              ;:dark (oget cyanColor "900")
;                                                              ;:contrastText "#000"}}
;                                      :typography {:fontSize "16"}})))

;(set! (-> theme .-typography .-fontSize) 28)

; (js/console.log "theme" theme)
; (js/console.log "=>" (oget theme ".palette.background.paper"))
;(js/console.log "cljs theme" (js->clj theme))


(defn app []
  (let [user (subscribe [:user])]
    (fn []
      [:> MuiThemeProvider
       {:theme theme}
       (if @user
         [routes/main-component])])))

(defn render []
  (r/render [app]
            (js/document.getElementById "app")))

(defn on-window-resize []
  (dispatch [:window-width (oget js/window "innerWidth")]))

(defn ^:export init []
  (dispatch-sync [:initialize])
  (firebase-init)
  (routes/init-routes)
  ;(dispatch-sync [:update-theme (js->clj theme)])
  ;(js/console.log "cljs theme" @(subscribe [:get-theme]))
  (render)
  (ocall js/window "addEventListener" "resize" on-window-resize))
