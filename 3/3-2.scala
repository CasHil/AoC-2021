import scala.io.Source

def rate(numbers : List[Int], digits : List[Int], longest: Int, oxygen: Int) : Int = {
    println(numbers)
    if (longest == 0) return Integer.parseInt(digits.mkString, 2)
    if (numbers.map(num => num & oxygen).sum > numbers.length / 2 && oxygen == 1) {
        rate(numbers.filter(n => (n & oxygen) == 1).map(num => num >> 1), 1 :: digits, longest - 1, oxygen)
    }
    else if (numbers.map(num => num & oxygen).sum == numbers.length / 2) {
        rate(numbers.filter(n => (n & oxygen) == oxygen).map(num => num >> 1), oxygen :: digits, longest - 1, oxygen)
    }
    else {
        rate(numbers.filter(n => (n & oxygen) == oxygen).map(num => num >> 1), 0 :: digits, longest - 1, oxygen)
    }
}

def toPrintableOutput(oxygenRate : Int, co2Rate : Int) : String = {
    println(oxygenRate)
    println(co2Rate)
    (oxygenRate * co2Rate).toString
}

val lines = Source.fromFile("input-3.txt").getLines.toList
val intLines = lines.map(binaryString => Integer.parseInt(binaryString, 2))
println(toPrintableOutput(rate(intLines, List[Int](), lines.maxBy(_.length).length, 1), rate(intLines, List[Int](), lines.maxBy(_.length).length, 0)))

