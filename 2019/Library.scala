import scala.annotation.tailrec
import java.time.{Duration, Instant}

val answers = {
  inputFile("answers.txt").map(_.split(" "))
                          .map(a => (a(0), a(1)))
                          .toMap
}

def timeAndPrintSolution[A](number: String, f: () => A): Unit = {
  val start = Instant.now()
  val result = f()
  val d = Duration.between(start, Instant.now())
  val correct = answers.get(number).exists(_ == result.toString)
  val check = if (correct) "✓" else "✗"
  System.out.println(number + " (" + d.toMillis + "ms):\t" + result.toString + " " + check)
}

def inputFile(filename: String): Iterator[String] = {
  scala.io.Source.fromFile(filename).getLines()
}

def listOfIntsFile(filename: String): Array[Int] = {
  inputFile(filename).mkString.split(",").map(_.trim.toInt)
}
