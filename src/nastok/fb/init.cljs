(ns nastok.fb.init
  (:require ["firebase" :as firebase]
            [nastok.fb.auth :as fb-auth]
            ;[oops.core :refer [ocall oget]]
            [nastok.config]))

(defn firebase-init
  []
  (let []
    (firebase/initializeApp (clj->js nastok.config/firebase))
    (fb-auth/on-auth-state-changed!)))
