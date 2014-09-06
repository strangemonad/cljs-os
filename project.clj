(defproject os "0.1.0-SNAPSHOT"
  :description "Simple clojurescript child process execution."
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/core.async "0.1.338.0-5c5012-alpha"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "os"
              :source-paths ["src"]
              :compiler {
                :output-to "out/os.js"
                :output-dir "out"
                :optimizations :none
                :source-map true
                :target :nodejs}}]})
