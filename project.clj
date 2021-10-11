(defproject lab-1 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"] [org.clojure/algo.generic "0.1.3"] [rm-hull/infix "0.4.0"] [pjstadig/humane-test-output "0.11.0"]]
  :plugins [
            [lein-cljfmt "0.8.0"]
            [cider/cider-nrepl "0.26.0"]
            [com.jakemccrary/lein-test-refresh "0.24.1"]
            ]
  :injections [(require 'pjstadig.humane-test-output)])