fun main(){

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
                        val reverseStringLengthEnd = reverseStringEnd.length
                        val palindromeLengthEnd = palindromeEnd.length
                        reverseStringEnd = (reverseStringEnd.removeRange(reverseStringLengthEnd-1 , reverseStringLengthEnd))
                        reverseStringEnd = reverseStringEnd.reversed();
                        palindromeEnd = palindromeEnd.removeRange(palindromeLengthEnd - 1, palindromeLengthEnd)
                        when{
                            (palindromeLengthEnd == 2) -> {
                                while (!trueOrFalseStart){
                                    val palindromeLengthStart = palindromeStart.length
                                    reverseStringStart = (reverseStringStart.removeRange(0, 1))
                                    reverseStringStart = reverseStringStart.reversed()
                                    palindromeStart = palindromeStart.removeRange(0, 1)
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
