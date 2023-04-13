package kristileka.zsh

import scala.io.StdIn.readLine

import kristileka.zsh.state.State

object Main extends App {
  var state = State()
  while (true) {
    print("-> tmp ")
    val command = readLine()
    state = state.evaluate(command)
  }
}
