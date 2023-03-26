fun main(){
    ExC(2)
    //это мой первыый проект на гитхабе

}

fun ExA(hour: Int, minutes: Int){
    var mirroredHour = hour
    var mirroredMinutes = minutes
    when{
        (hour in 0..11 && minutes in 0..59) -> {
            when{
                ((hour == 6 && minutes == 30) || (hour == 0 && minutes == 0)) -> println("$hour $minutes")
                ((hour == 6 &&  minutes == 0) || (hour == 0 &&  minutes == 30)) -> println("$hour $minutes")
                (hour == 6 || hour == 0) -> {
                    mirroredMinutes -= 60
                    when{
                        (mirroredMinutes < 0) -> {println("$mirroredHour ${mirroredMinutes * -1}")}
                    }
                }
                (minutes == 30 || minutes == 0) -> {
                    mirroredHour -= 12
                    when{
                        (mirroredHour < 0) -> {println("${mirroredHour * -1} $mirroredMinutes")}
                    }
                }
                else -> {
                    mirroredHour -= 12; mirroredMinutes -= 60
                    when{
                        (mirroredHour < 0 && mirroredMinutes < 0) -> {println("${mirroredHour * -1} ${mirroredMinutes * -1}")}
                    }
                }
            }
        }
        else -> println("numbers out of range")
    }
}

fun ExB(string: String){
    var reverseStringEnd = string//.reversed()
    var palindromeEnd = string
    var reverseStringStart = string//.reversed()
    var palindromeStart = string
    var trueOrFalseEnd = false
    var trueOrFalseStart = false
    when{
        (string.length in 2..200000) -> {
            when{
                (palindromeEnd == reverseStringEnd.reversed()) -> println(palindromeEnd)
                else -> {
                    while (!trueOrFalseEnd){
                        var reverseStringLengthEnd = reverseStringEnd.length
                        var palindromeLengthEnd = palindromeEnd.length; //println("$palindromeLengthEnd ------ len")
                        reverseStringEnd = (reverseStringEnd.removeRange(reverseStringLengthEnd-1 , reverseStringLengthEnd)); //println(reverseStringEnd)
                        reverseStringEnd = reverseStringEnd.reversed(); //println("$reverseStringEnd ----- reverse")
                        palindromeEnd = palindromeEnd.removeRange(palindromeLengthEnd - 1, palindromeLengthEnd); //println("$palindromeEnd ------- palEnd")
                        when{
                            //(palindromeLength == 1) -> {println("-1"); trueOrFalse = true}
                            (palindromeLengthEnd == 2) -> {
                                //println("im here")
                                while (!trueOrFalseStart){
                                    //var reverseStringLengthStart = reverseStringStart.length
                                    var palindromeLengthStart = palindromeStart.length; //println(palindromeLengthStart)
                                    reverseStringStart = (reverseStringStart.removeRange(0, 1)); //println(reverseStringStart)
                                    reverseStringStart = reverseStringStart.reversed(); //println("$reverseStringStart ------ reverse")
                                    palindromeStart = palindromeStart.removeRange(0, 1); //println("$palindromeStart ----- palStart")
                                    when{
                                        (palindromeLengthStart == 2) -> {
                                            println("-1");
                                            trueOrFalseStart = true; trueOrFalseEnd = true}
                                        (palindromeStart == reverseStringStart) -> {
                                            println(palindromeStart);
                                            trueOrFalseStart = true; trueOrFalseEnd = true
                                        }
                                        else -> reverseStringStart = reverseStringStart.reversed()
                                    }
                                }
                            }
                            (palindromeEnd == reverseStringEnd) -> {println(palindromeEnd); trueOrFalseEnd = true}
                            else -> reverseStringEnd = reverseStringEnd.reversed()
                        }
                    }
                }
            }
        }
        else -> println("string length out of range")
    }
}

fun ExC(iterations: Int){
    fun checkingConditions(mode: Int, list: List<String>): Boolean{
        var bool: Boolean = false
        when{
            (mode == 0) -> {
                if (list[1].toInt() in 1..1000){
                    if (list.size == 4){
                        for (item in 2 until list.size){
                            when{
                                (list[item].toInt() in -10000..10000) -> {}
                                else -> return bool
                            }
                        }
                        bool = true
                    }
                }
            }
            (mode == 1) -> {
                //print("im here")
                if (list.size == 9){
                    for (item in 1 until list.size){
                        when{
                            (list[item].toInt() in -10000..10000) -> {}
                            else -> return bool
                        }
                    }
                    bool = true
                }
            }
        }
        return bool
    }

    for (iteration in 1..iterations){
        print("Target - "); var target = readln().split(" ")
        println(target.size)
        when{
            (target[0] == "0") -> {
                //println(checkingConditions(0, target))
                when{
//                    (target[1].toInt() in 1..1000 && -10000 <= target[2].toInt() && -10000 <= target[3].toInt() && target.size == 4) -> {
//                        println("okok")
//                    }
                    (checkingConditions(0, target))  -> {
                        println("okok")

                    }
                    else -> println("error")
                }
            }
            (target[0] == "1") -> {
                when{
                    (checkingConditions(1, target)) -> println("okok")
                    else -> println("error")
                }

            }
            else -> println("error")
        }
    }

}
