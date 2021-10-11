(defproject lab-1 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"] [same/ish "0.1.4"] [rm-hull/infix "0.4.0"]]
  :plugins [[lein-cljfmt "0.8.0"] [cider/cider-nrepl "0.26.0"] [com.gfredericks/lein-how-to-ns "0.2.9"]]
  :repl {:plugins [[cider/cider-nrepl "0.25.2"]]}
  :repl-options {:init-ns lab-1.core})
