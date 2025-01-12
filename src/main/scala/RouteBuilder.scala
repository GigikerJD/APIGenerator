
case class Route(method: String, path: String, handlerName: String, description: Option[String])

class RouteBuilder(path: String) {
  private var routes: List[Route] = List()
  
  def get(name: String)(block: => Unit): Unit = {
    routes = routes :+ Route("GET", path, name, None)
    block
  }
  
  def post(name: String)(block: => Unit): Unit = {
    routes = routes :+ Route("POST", path, name, None)
    block
  }
  
  def description(desc: String): Unit = {
    if (routes.nonEmpty) {
      val lastRoute = routes.last
      routes = routes.dropRight(1) :+ lastRoute.copy(description = Some(desc))
    }
  }
  
  def build(): List[Route] = routes
}