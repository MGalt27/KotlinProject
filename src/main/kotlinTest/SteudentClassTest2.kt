import studentClassTest.Student
import studentClassTest.Group
import java.time.Instant

fun main(){
//    val makismGrades = readln().split(" ").map(String::toInt)
//    val maksim = Student("Maksim", 17, 2, makismGrades)
//    maksim.studentCard()
//    println(maksim.toString())
    println("time is ${ timeSpeed { test() } }, sec")

}

fun timeSpeed(mes: () -> Unit): Long{
    val time1 = Instant.now()
    mes()
    val time2 = Instant.now()
    return time2.epochSecond - time1.epochSecond
}

fun test(){
    val MaksimGrade = listOf<Int>(5, 5, 5, 2, 2, 3, 4, 4, 4)
    val Maksim = Student("Maksim", 17, 2, MaksimGrade)
    val IgorAverage = listOf<Int>(5, 4, 3, 2, 1, 5)
    val Igor = Student("Igor", 19,3, IgorAverage)
    val groupMath = Group("math group")
    groupMath.addStudent(Maksim)
    groupMath.addStudent(Igor)
    groupMath.groupCard()
}