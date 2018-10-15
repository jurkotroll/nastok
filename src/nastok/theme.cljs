(ns nastok.theme
  (:require
   [oops.core :refer [ocall oget oset!]]
   

   ["@material-ui/core/styles" :refer [MuiThemeProvider createMuiTheme]]
   ["@material-ui/core/colors/cyan" :default cyanColor]
   ["@material-ui/core/colors/purple" :default purpleColor]
   ["@material-ui/core/colors/red" :default redColor]))



(def theme (createMuiTheme (clj->js {:palette
                                             {:primary {:light (oget cyanColor "400")
                                                        :main (oget cyanColor "600")
                                                        :dark (oget cyanColor "900")
                                                        :contrastText "#fff"}
                                                ;{}
                                                 ; :primary {;:light (oget purpleColor "100")
                                                 ;           :main (oget purpleColor "300")
                                                 ;           ;:dark (oget purpleColor "600")
                                                 ;           :contrastText (.-getContrastText (oget purpleColor "300"))}
                                                 :secondary {;:light (oget cyanColor "700")
                                                             :main (oget cyanColor "800")}}
                                                 ;:type "light"}
                                                             ;:dark (oget cyanColor "900")
                                                             ;:contrastText "#000"}}
                                     :typography {:fontSize "16"}})))

;(set! (-> theme .-typography .-fontSize) 28)

; (js/console.log "theme" theme)
; (js/console.log "=>" (oget theme ".palette.background.paper"))
;(js/console.log "cljs theme" (js->clj theme))
