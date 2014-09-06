(ns sm.os.exec
  "Namespace sm.os.exec exposes child-process execution inspired by Go's os/exec."

  (:require [cljs.core.async :refer [put! chan]]
            [sm.os.child-process :as cp])
  (:require-macros [cljs.core.async.macros :refer [go]]))

; TODO cmd as a protocol / typedef vs map?
; TODO nicer high-level macro functions
; TODO Fuller docs
; TODO test suit
; TODO better process exit code support

;; exit code error?

(defn cmd
  ([name] (cmd name nil))
  ([name & args] {:name name :args args}))

(defn output [cmd]
  (let [cmd-str (:name cmd)
        ; TODO args into opts
        out (chan 1)]
    (go (sm.os.child-process/exec cmd-str
             (fn [err stdout]
               (put! out [stdout err]))))
    out))

(comment

  (def cmd (command "pwd"))
  (combined-output cmd
    (fn [out err]
      if err (println err)
      (println out)))
  )
