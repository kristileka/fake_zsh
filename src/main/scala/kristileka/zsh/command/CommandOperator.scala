package kristileka.zsh.command

object CommandOperator {
  private val commands: List[Command] = List(
    Mkdir(),
    Ls()
  )

  def find(command: String): Command = {
    commands.find(_.fromString(command)) match {
      case Some(foundCommand) => foundCommand
      case None               => CommandNotFound()
    }
  }
  def findProperties(input: String,
                     command: Command): Either[String, List[String]] = {
    command.validate(input) match {
      case None        => Right(command.retrieveProperties(input))
      case Some(issue) => Left(issue)
    }
  }
}
