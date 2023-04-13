package kristileka.zsh.command

import java.nio.file.{Files, Paths}

class Mkdir extends Command {
  override val parameters: List[String] = List("*")
  override val baseCommand = "mkdir"

  override def retrieveProperties(input: String): List[String] = {
    List(input.split(" ").toList(1))
  }
  override def execute(directory: String,
                       properties: List[String]): (String, Option[String]) = {

    val path = Paths.get(directory + s"/${properties.head}")
    if (!(Files.exists(path) && Files.isDirectory(path))) {
      Files.createDirectory(path)
      (path.toString, None)
    } else {
      ("", Some("Folder already exists!"))
    }
  }

  override def validate(command: String): Option[String] =
    if (command.split(" ").length != 2)
      Some("Please include the directory: `mkdir test`")
    else None
}
object Mkdir {
  def apply(): Mkdir = {
    new Mkdir()
  }
}
