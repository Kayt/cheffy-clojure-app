(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.db]
            ;;----------nav--------------
            [app.nav.events]
            [app.nav.subs]
            [app.nav.views.nav :refer [nav]]
            ;;----------auth--------------
            [app.auth.views.signup :refer [signup]]
            [app.auth.views.login :refer [login]]
            ;;----------BEcome a chef--------------
            [app.become-a-chef.events]
            [app.become-a-chef.subs]
            [app.become-a-chef.views.become-a-chef :refer [become-a-chef]]
            ;;----------recipes--------------
            [app.recipes.events]
            [app.recipes.subs]
            [app.recipes.views.recipes :refer [recipes]]
            ;;----------profile--------------
            [app.profile.events]
            [app.profile.subs]
            [app.profile.views.profile :refer [profile]]
            ;;----------inbox--------------
            [app.inbox.events]
            [app.inbox.subs]
            [app.inbox.views.inboxes :refer [inboxes]]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Normalize ThemeProvider Row Col Grid]]))

(defn pages
  [page-name]
  (case page-name
    :profile [profile]
    :become-a-chef [become-a-chef]
    :inbox [inboxes]
    :recipes [recipes]
    :login [login]
    :signup [signup]
    :default [recipes]))

(defn app
  []
  (let [active-nav @(rf/subscribe [:active-nav])]
    [:<>
     [:> Normalize]
     [:> Grid {:fluid false}
      [:> Row
       [:> Col
        [nav]
        [pages active-nav]]]]]))
   

(defn ^:dev/after-load start
  []
  (rf/dispatch-sync [:initialize-db])
  (r/render [app]
    (.getElementById js/document "app")))

(defn ^:export init
  []
  (start))
