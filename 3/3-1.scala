import scala.io.Source

def gammaRate(numbers : List[Int], count : List[Int], longest: Int) : (List[Int], List[Int]) = {
    if (longest == 0) return (numbers, count)
    if (numbers.map(num => num & 1).sum > numbers.length / 2) gammaRate(numbers.map(num => num >> 1), 1 :: count, longest - 1)
    else gammaRate(numbers.map(num => num >> 1), 0 :: count, longest - 1)
}
def epsilonRate = (count: List[Int]) => count.map(num => num ^ 1)

def toPrintableOutput(gamma : List[Int]) : String = {
    (Integer.parseInt(gamma.mkString, 2) * Integer.parseInt(epsilonRate(gamma).mkString, 2)).toString
}

val lines = Source.fromFile("input-3.txt").getLines.toList
println(toPrintableOutput(gammaRate(lines.map(binaryString => Integer.parseInt(binaryString, 2)), List[Int](), lines.maxBy(_.length).length)._2))

