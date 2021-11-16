
class Calculator {
    fun operation(operator:String, a:Double, b:Double):Double {
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