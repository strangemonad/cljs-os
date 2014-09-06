(ns examples
    (:require [cljs.core.async :refer [put! chan <!]]
              [cljs.nodejs :as nodejs]
              [sm.os.exec :as exec])
    (:require-macros [cljs.core.async.macros :refer [go]]))

(nodejs/enable-util-print!)

(defn -main []
  (go
    (let [cmd (exec/cmd "bash -c 'exit 1'")
          [stdout err] (<! (exec/output cmd))]
    (println stdout)
    (println err))))

(set! *main-cli-fn* -main)
