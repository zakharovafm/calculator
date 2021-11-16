

fun main (args: Array<String>){
    val calculator = Calculator()
    val operation:String = readLine().toString()
    println(calculator.calculate(operation))
}