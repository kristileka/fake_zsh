package kristileka.zsh.command

trait Command {
  val baseCommand: String
  val parameters: List[String]
  def fromString(input: String): Boolean =
    input.startsWith(this.baseCommand)
  def retrieveProperties(input: String): List[String] = List()
  def validate(input: String): Option[String]
  def execute(directory: String,
              properties: List[String]): (String, Option[String])
}
