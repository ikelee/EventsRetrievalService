
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ike.lee/Documents/scalaPlaySkeleton/conf/routes
// @DATE:Sun Dec 03 19:48:14 PST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
