@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double =
        when (v.isEmpty()) {
            true -> 0.0
            false -> Math.sqrt(v.map { it * it }.sum())
        }


/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = when {
    list.isEmpty() -> 0.0
    else -> list.sum() / (list.size)
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (list.isNotEmpty()) {
        val middle = mean(list)
        for (i in 0..list.lastIndex) {
            list[i] -= middle
        }
    }
    return list

}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double = when {
    a.isEmpty() || b.isEmpty() -> 0.0
    else -> {
        var sum = 0.0
        for (i in 0..a.lastIndex)
            sum += a[i] * b[i]
        sum //Вывод
    }
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double = when {
    p.isEmpty() -> 0.0
    else -> {
        var sum = 0.0
        for (i in 0..p.lastIndex)
            sum += p[i] * Math.pow(x, i.toDouble())
        sum
    }
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> = when {
    list.isEmpty() -> list
    else -> {
        var sum = list[0]
        for (i in 1..list.lastIndex) {
            val temporary = list[i]
            list[i] += sum
            sum += temporary
        }
        list
    }
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var divisor = 2
    var x = n
    val list = mutableListOf<Int>()
    while (x > 1) {
        if (x % divisor == 0) {
            x /= divisor
            list.add(divisor)
        } else divisor++
    }
    return list
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 *
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var x = n
    if (x == 0) return listOf(0)
    else {
        val answer = mutableListOf<Int>()

        while (x > 0) {
            answer.add(x % base)
            x /= base
        }
        return answer.reversed()
    }
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    if (n == 0) return "0"
    else {
        val list = convert(n, base)
        val alfabet = "abcdefghijklmnopqrstuvwxyz"
        var answer = ""
        for (i in 0..list.lastIndex) {
            answer += if (list[i] < 10) list[i]
            else alfabet[list[i] - 10]
        }
        return answer
    }
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var x = 0
    val answer = digits.reversed()
    for (i in 0..answer.lastIndex)
        x += answer[i] * Math.pow(base.toDouble(), i.toDouble()).toInt()
    return x
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    if (str.isEmpty() || str == "0") return 0
    var answer = 0
    val variants = "0123456789abcdefghijklmnopqrstuvwxyz"
    for (i in str.lastIndex downTo 0) {
        answer += variants.indexOf(str[i]) *
                Math.pow(base.toDouble(), str.lastIndex - i.toDouble()).toInt()
    }
    return answer
}

/**
 * Вспомогательная
 *
 * Получая на ввод, например, (I, V, X, 4), она выводит строку "IV"
 *
 */
fun digittoroman(a: String, b: String, c: String, n: Int): String {
    var answer = ""
    when {
        n in 1..3 ->
            for (i in 1..n)
                answer += a

        n == 5 -> answer += b

        n in 6..8 -> {
            answer += b
            for (i in 6..n)
                answer += a
        }
        n == 4 -> {
            answer += a
            answer += b
        }
        n == 9 -> {
            answer += a
            answer += c
        }
    }
    return answer
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var answer = ""
    val one = n % 10
    val ten = (n % 100) / 10
    val hundred = (n % 1000) / 100
    for (i in 1..n / 1000) {
        answer += "M"
    }
    answer += digittoroman("C", "D", "M", hundred)
    answer += digittoroman("X", "L", "C", ten)
    answer += digittoroman("I", "V", "X", one)
    return answer
}

/**
 * Вспомогательная
 *
 * Переводит Int в строку
 */
fun inttorussian(x: Int, code: Int): String {
    val answer = mutableListOf<String>()
    val hundred = x / 100
    val ten = (x % 100) / 10
    val one = x % 10
    val list100 = listOf<String>("", "сто", "двести", "триста", "четыреста",
            "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    val list15 = listOf<String>("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val list50 = listOf<String>("", "", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
    val list1 = listOf<String>("", "один", "два", "три", "четыре", "пять", "шесть", "семь",
            "восемь", "девять")
    val list1alternative = listOf<String>( "", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи",
            "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч")
    if (hundred != 0) answer += list100[hundred]
    if (code == 2 && ten + one == 0 && hundred != 0) {
        answer += "тысяч"
        return answer.joinToString(separator = " ")
    }
    if (ten == 1) {
        answer += list15[one]
        if (code == 2) answer += "тысяч"
        return answer.joinToString(separator = " ")
    } else {
        if (ten in 2..9) answer += list50[ten]
        if (code == 2 && one != 0)answer += list1alternative[one]
                else if(one != 0) answer += list1[one]
        }
        return answer.joinToString(separator = " ")
    }

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val thousand = n / 1000
    val one = n % 1000
    when (inttorussian(thousand, 2) == "" || inttorussian(one, 1) == "") {
        true -> return inttorussian(thousand, 2) + inttorussian(one, 1)
        false -> return inttorussian(thousand, 2) + " " + inttorussian(one, 1)
    }
}


