;; Private helper package to work with child process.
(ns sm.os.child-process
  "Namespace sm.os.child-process wraps node.js Child Process.

  This is an internal helper library.
  Assumes the environment is node.js rather than the browser."
  (:require [cljs.nodejs :as nodejs]))

; TODO wrap spawn to get exit code? Why doens't exec give exit code.
; TODO probably belongs in a more common (sm.node) - how to require in LT?

(def ^:private child-proc (nodejs/require "child_process"))

(defn exec
  "Execute a child process.

  When the child process exits, invoke '(callback error stdout stderr)'.
  The single argument version is provided as a convenience but probably
  shouldn't be used in production code.

  See http://nodejs.org/api/child_process.html for details
  - cmd: the command string.
  - opts: a JS map of options as defined in the Child Process docs.
  - callback: callback function invoked when the child process exits
      - error: nil if no error otherwise an Error
      - stdout: a buffer, '(str stderr)' for the result
      - stderr: a buffer, '(str stderr)' for the result

  Returns a ChildProcess.
  "
  ([cmd] (exec cmd (fn [error stdout stderr] (println stderr))))
  ([cmd callback] ((.-exec child-proc) cmd callback))
  ([cmd opts callback] ((.-exec child-proc) cmd opts callback)))
