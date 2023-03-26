fun main(){

}

fun firstTask(){
    val numbers = arrayOf(3, 5, 6, 9)
    val range = 0..9
    print("num -> "); val num = readln().toInt()
    when{
        (num < 0) -> println("0")
        (num in range) -> {
            when{
                else -> {
                    var sum = 0
                    for (digit in 0..(numbers.size-1)){
                        when{
                            (numbers[digit] <= num) -> sum += numbers[digit]
                        }
                    }
                    println(sum)
                }
            }
        }
        else -> println("num out of range")
    }
}

fun secondTask(line: String): String{
    var word =  line //readLine().toString()
    when{
        ('-' in word || '_' in word) -> {
            for (digit in 0..(word.length - 1)) {
                when {
                    (word[digit] == '-') -> word = word.replace(word[digit + 1], word[digit + 1].uppercaseChar())
                    (word[digit] == '_') -> word = word.replace(word[digit + 1], word[digit + 1].uppercaseChar())
                }
            }
        }
        else -> println("'-' or '_' is empty")
    }
    when{
        ('_' in word && "-" in word) -> {
            word = word.filterNot { it == '_' }
            word = word.filterNot { it == '-' }
        }
        ('-' in word) -> word = word.filterNot { it == '-' }
        ('_' in word) -> word = word.filterNot { it == '_' }
    }
    return word
}

fun thirdTask(a: Int, b: Int, c: Int, d: Int): String {
    val arrayNumber = arrayOf(a, b, c, d)
    var newArray = arrayOf(arrayOf("", ""), arrayOf("", ""))
    val squareAB = (a * a) + (b * b)
    val squareCD = (c * c) + (d * d)
    val n = squareAB * squareCD
    when{
        (arrayNumber.size == 4) -> {
            var e = (arrayNumber[1] * arrayNumber[2]) - (arrayNumber[0] * arrayNumber[3])
            when{
                (e<0) -> e *= -1
            }
            val f = (arrayNumber[1] * arrayNumber[3]) + (arrayNumber[0] * arrayNumber[2])
            val i = (arrayNumber[1] * arrayNumber[3]) - (arrayNumber[0] * arrayNumber[2])
            val o = (arrayNumber[0] * arrayNumber[3]) + (arrayNumber[1] * arrayNumber[2])
            when{
                (e == i && f == o) -> {
                    newArray[0][0] = e.toString()
                    newArray[0][1] = f.toString()
                    val newArrayLine = "[${newArray[0].contentToString()}]"
                    return newArrayLine
                }
                else -> {
                    newArray[0][0] = e.toString()
                    newArray[0][1] = f.toString()
                    newArray[1][0] = i.toString()
                    newArray[1][1] = o.toString()
                }
            }
        }
    }
    val newArrayLine = "[${newArray[0].contentToString()}, ${newArray[1].contentToString()}]"
    return newArrayLine
}