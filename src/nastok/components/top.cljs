(ns nastok.components.top
  (:require [re-frame.core :refer [subscribe dispatch]]
            [reagent.core :as r]
            ["@material-ui/core/AppBar" :default AppBar]
            ["@material-ui/core/Toolbar" :default Toolbar]
            ["@material-ui/core/IconButton" :default IconButton]
            ["@material-ui/icons/Menu" :default MenuIcon]
            ["@material-ui/icons/AccountCircle" :default AccountCircle]
            ["@material-ui/core/Button" :default Button]
            ["@material-ui/core/Menu" :default Menu]
            ["@material-ui/core/MenuItem" :default MenuItem]
            ["@material-ui/core/List" :default List]
            ["@material-ui/core/Avatar" :default Avatar]
            ["@material-ui/core/Tooltip" :default Tooltip]
            ["@material-ui/core/ListItem" :default ListItem]
            ["@material-ui/core/Typography" :default Typography]
            [nastok.fb.auth :refer [sign-in-with-facebook sign-out]]
            [reitit.frontend.easy :as rfe]
            [fipp.edn :as fedn]))

(defn login []
  (let []
    (fn []
      [:div
       [:> Tooltip {:title "Log-in" :placement "left"}
        [:> IconButton {:color "inherit" :label "Log-in" :on-click #(sign-in-with-facebook)}
         [:> AccountCircle]]]])))

(defn logged-in-user-pane [user]
   (let [anchor-el (r/atom nil)
         handle-menu (fn [e]
                       (reset! anchor-el (-> e .-currentTarget)))
                       ;(println @anchor-el))

         handle-close #(reset! anchor-el nil)]

    (fn []
     (let [menuopen! (r/atom (some? @anchor-el))]
      (println "anchor-el " (str (when @menuopen! (.-id @anchor-el))))
      (println "menuopen! " @menuopen!)
      ;(println "menuopen2! " (menuopen2!))
      [:div.right-pane
       [:> IconButton {:id "avatar-button"
                       :on-click handle-menu
                       :aria-owns (if (some? @anchor-el) "menu-appbar" nil)
                       :aria-haspopup "true"}
        [:> Avatar {:src (:photo @user) :alt (:name @user)}]]
       [:> Menu {:id "menu-appbar"
                 :open (some? @anchor-el);@menuopen!
                 :anchorEl @anchor-el
                 :anchorOrigin {:vertical "top"
                                :horizontal "right"}
                 :transformOrigin {:vertical "top"
                                   :horizontal "right"}
                 :on-close handle-close}
        [:> MenuItem {:on-click #(sign-out)} "Loggout"]]]))))


(defn bar []
  (let [user (subscribe [:user])]
    (fn []
      [:div {:style {:flexGrow 1}}
       [:> AppBar {:position "fixed" :class "top-bar"}
        [:> Toolbar {:style {:min-height 64} :color "primary"}
         [:> IconButton {:style {:margin-right 20 :margin-left -12}}
          [:> MenuIcon {:style {:color "white"}}]]
         [:> Typography {:variant "headline" :color "inherit" :style {:flexGrow 1}}
           "Razem na stok"]
         (if (empty? @user)
           [login]
           [logged-in-user-pane user])]]])))
