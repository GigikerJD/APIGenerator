object UserManagement extends App {
  // Définition d'un modèle utilisateur
  val userModel = new ModelBuilder("User")
  userModel.field("id", "Int", isPrimaryKey = true)
  userModel.field("name", "String", isRequired = true)
  userModel.field("email", "String", isRequired = true)
  userModel.field("age", "Int", isRequired = false)

  println(userModel.build())

  // Définition des routes
  val userRoutes = new RouteBuilder("/users")
  userRoutes.get("getAllUsers") {
    userRoutes.description("Fetch all users")
  }

  userRoutes.post("createUser") {
    userRoutes.description("Create a new user")
  }

  println(userRoutes.build())
}
