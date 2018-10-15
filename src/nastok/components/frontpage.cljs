(ns nastok.components.frontpage
  (:require
    [nastok.theme :refer [theme]]
    [oops.core :refer [ocall oget oset!]]

    [re-frame.core :refer [subscribe dispatch]]
    ["@material-ui/core/Typography" :default Typography]
    ["@material-ui/core/Paper" :default Paper]
    ["@material-ui/core/Grid" :default Grid]
    ["@material-ui/core/Button" :default Button]

    [cljs-css-modules.macro :refer-macros [defstyle]]))

(let [;theme (subscribe [:get-theme])
      typo-text-color (oget theme ["palette" "text" "primary"])
      buttons-marg-top (* 4 (oget theme ["spacing" "unit"]))]

  (defstyle styles
     [".typo" {:color typo-text-color}]
     [".hero-buttons" {:margin-top buttons-marg-top}]))

(defn toptext []
  (let []
    (fn []
      [:div
         [:> Typography {:class-name (:typo styles) :align "center" :component "h2" :variant "h2" :gutter-bottom true :color "textPrimary"}
             "Front Page"]
         [:> Typography {:variant "h6" :align "center" :color "textSecondary" :paragraph true}
             "Something short and leading about the collection below—its contents, the creator, etc.
              Make it short and sweet, but not too short so folks don&apos;t simply skip over it
              entirely."]])))

(defn buttons []
  (let []
    (fn []
      [:div {:class-name (:hero-buttons styles)}
        [:> Grid {:container true :spacing 16 :justify "center"}
          [:> Grid {:item true}
            [:> Button {:variant "contained" :color "primary"}
              "Main call to action"]]
          [:> Grid {:item true}
            [:> Button {:variant "outlined" :color "primary"}
                "Secondary action"]]]])))

(defn album []
  (let []
    (fn []
      [:div])))
