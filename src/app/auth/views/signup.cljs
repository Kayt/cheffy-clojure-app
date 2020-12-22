(ns app.auth.views.signup
  (:require [app.components.page-nav :refer [page-nav]]))

(defn signup
  []
  [page-nav {:center "Sign Up"}])