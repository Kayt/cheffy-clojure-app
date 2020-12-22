(ns app.nav.events
  (:require [re-frame.core :as rf]))

(rf/reg-event-db
 :set-active-nav
 (fn [db [_ active-nav]]
   (assoc-in db [:nav :active-nav] active-nav)))
