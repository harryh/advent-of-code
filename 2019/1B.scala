@tailrec
def calcFuel(acc: Int)(n: Int): Int = {
  if(n == 0) {
    acc 
  } else {
    val f = Math.max(0, n / 3 - 2)
    calcFuel(acc + f)(f)
  }
}

inputFile("1.txt").map(_.toInt)
                  .map(calcFuel(0))
                  .sum
