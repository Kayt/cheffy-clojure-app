(ns app.nav.views.public
  (:require ["@smooth-ui/core-sc" :refer [Box]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [app.nav.views.nav-item :refer [nav-item]]))

(defn public
  []
  (let [active-nav @(rf/subscribe [:active-nav])
        nav-items [{:id :recipes
                    :name "Recipes"
                    :href "#recipes"
                    :dispatch #(rf/dispatch [:set-active-nav :recipes])}
                   {:id :become-a-chef
                    :name "Chef"
                    :href "#become-a-chef"
                    :dispatch #(rf/dispatch [:set-active-nav :become-a-chef])}
                   {:id :signup
                    :name "Sign Up"
                    :href "#signup"
                    :dispatch #(rf/dispatch [:set-active-nav :signup])}
                   {:id :login
                    :name "Login"
                    :href "#login"
                    :dispatch #(rf/dispatch [:set-active-nav :login])}]]
    [:> Box {:display "flex"
             :justify-content "flex-end"
             :py 1}
     (for [{:keys [id name href dispatch]} nav-items]
       [nav-item {:key id
                  :id id
                  :name name
                  :href href
                  :dispatch dispatch
                  :active-nav active-nav}])]))
