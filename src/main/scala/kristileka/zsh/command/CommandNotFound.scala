package kristileka.zsh.command

case class CommandNotFound() extends Command {
  override val baseCommand: String = "NONE"
  override val parameters: List[String] = List()

  override def execute(directory: String,
                       properties: List[String]): (String, Option[String]) =
    ("Command Not Found", None)

  override def validate(input: String): Option[String] = None
}
