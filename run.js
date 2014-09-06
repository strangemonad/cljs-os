try {
    require("source-map-support").install();
} catch(err) {
}
require("./out/goog/bootstrap/nodejs.js");
require("./out/os.js");
goog.require("sm.os.core");
goog.require("cljs.nodejscli");
