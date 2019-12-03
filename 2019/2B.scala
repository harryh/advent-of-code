val memory = listOfIntsFile("2.txt")
val desiredOutput = 19690720

def execute(memory: Array[Int], noun: Int, verb: Int): Int = {
  memory(1) = noun
  memory(2) = verb

  var ip = 0

  while (memory(ip) != 99) {
    val op1 = memory(ip + 1)
    val op2 = memory(ip + 2)
    val op3 = memory(ip + 3)
    memory(ip) match {
      case 1 => memory(op3) = memory(op1) + memory(op2)
      case 2 => memory(op3) = memory(op1) * memory(op2)
    }
    ip = ip + 4
  }

  memory(0)
}

(for {
  noun <- 0 to 99
  verb <- 0 to 99 if (desiredOutput == execute(memory.clone, noun, verb))
} yield noun * 100 + verb).head
