package kristileka.zsh

import scala.io.StdIn.readLine
import kristileka.zsh.state.State

import java.io

object Main extends App {
  var state = State()
  val RED = "\u001B[31m"
 while (true) {
    print(Console.GREEN + "➜ ")
    print(Console.BLUE + s"${state.currentDirectory} ")
    val command = readLine()
    state = state.evaluate(command)
  }
}
