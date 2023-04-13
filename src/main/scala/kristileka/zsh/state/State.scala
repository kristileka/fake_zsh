package kristileka.zsh.state

import kristileka.zsh.command.CommandOperator
import kristileka.zsh.common.Const.ROOT_DIRECTORY

import java.nio.file.{Files, Paths}

case class State(var currentDirectory: String) {
  def evaluate(value: String): State = {
    val command = CommandOperator.find(command = value)
    val properties = CommandOperator.findProperties(value, command)
    properties match {
      case Left(issue) => {
        println(issue)
        this
      }
      case Right(properties) =>
        command.execute(currentDirectory, properties) match {
          case (result, Some(directory)) =>
            println(result)
            State(directory)
          case (result, None) => {
            println(result)
            this
          }
        }
    }
  }
}

object State {
  def apply(): State = {
    val path = Paths.get(ROOT_DIRECTORY)
    if (!(Files.exists(path) && Files.isDirectory(path)))
      Files.createDirectory(path)
    new State(ROOT_DIRECTORY)
  }

}
