import scala.io.Source

object LifeSupport {
    def rate(numbers : List[String], oxygen: Int, index: Int) : Int = {
        if (numbers.length == 1) {
            return Integer.parseInt(numbers(0), 2)
        }
        if (numbers.map(num => num(index).asDigit).sum.toFloat > numbers.length / 2f) {
            rate(numbers.filter(n => n(index).asDigit == oxygen), oxygen, index + 1)
        }
        else if (numbers.map(num => num(index).asDigit).sum.toFloat == numbers.length / 2f) {
            rate(numbers.filter(n => n(index).asDigit == oxygen), oxygen, index + 1)
        }
        else {
            oxygen match {
                case 0 => rate(numbers.filter(n => n(index).asDigit == 1), oxygen, index + 1)
                case 1 => rate(numbers.filter(n => n(index).asDigit == 0), oxygen, index + 1)
            }
        }
    }

    def toPrintableOutput(oxygenRate : Int, co2Rate : Int) : String = {
        (oxygenRate * co2Rate).toString
    }

    def main(args: Array[String]): Unit = {
        val lines = Source.fromFile("input-3.txt").getLines().toList
        println(toPrintableOutput(rate(lines, 1, 0), rate(lines, 0, 0)))
    }
}