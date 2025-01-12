
case class Field(name: String, fieldType: String, isRequired: Boolean = false, isPrimaryKey: Boolean = false, isUnique: Boolean = false)

class ModelBuilder(name: String) {
  private var fields: List[Field] = List()

  def field(name: String, fieldType: String, isRequired: Boolean = false, isPrimaryKey: Boolean = false, isUnique: Boolean = false): Unit = {
    fields = fields :+ Field(name, fieldType, isRequired, isPrimaryKey, isUnique)
  }

  def build(): String = {
    s"case class $name(${fields.map(f => s"${f.name}: ${f.fieldType}").mkString(", ")})"
  }
}