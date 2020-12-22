(ns app.auth.views.login
  (:require [app.components.page-nav :refer [page-nav]])) 

(defn login
  []
  [page-nav {:center "Login"}])