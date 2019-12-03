val memory = listOfIntsFile("2.txt")
memory(1) = 12
memory(2) = 2

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
