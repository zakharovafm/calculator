import javax.management.InvalidAttributeValueException

class Calculator {
    private val operators = arrayOf("+", "-", "*", "/")

    fun calculate(value:String):String {
        var operator = ""
        var operatorIndex:Int = -1
        val trimValue = value.replace("\\s".toRegex(), "")

        run getOperator@ {
            operators.forEach {
                operatorIndex = trimValue.indexOf(it)

                if (operatorIndex != -1){
                    operator = trimValue[operatorIndex].toString()
                    return@getOperator
                }
            }
        }

        if(operatorIndex < 0){
            throw InvalidAttributeValueException("Ошибка, нет оператора")
        }

        val a:Double = trimValue.slice(0 until operatorIndex).toDouble()
        val b:Double = trimValue.substring(operatorIndex + 1).toDouble()
        return operation(operator, a, b).toString()
    }

    private fun operation(operator:String, a:Double, b:Double):Double {
        when (operator) {
            "+" -> return a + b
            "*" -> return a * b
            "-" -> return a - b
            "/" -> {
                if(b == 0.0) {
                    throw Exception("Деление на 0")
                }
                return a / b
            }

        }
        throw Exception("Введен неправильный оператор")
    }
}