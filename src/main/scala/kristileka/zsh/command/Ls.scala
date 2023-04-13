package kristileka.zsh.command

import java.io.File

class Ls extends Command {

  override val baseCommand: String = "ls"
  override val parameters: List[String] = List("-la")

  override def execute(directory: String,
                       properties: List[String]): (String, Option[String]) = {
    val file = new File(directory)
    val files = file.listFiles
      .map(_.getName)
      .toList
    (if (files.isEmpty) "" else files.toString(), None)
  }

  override def validate(input: String): Option[String] = None
}
object Ls {
  def apply(): Ls =
    new Ls()
}
