import java.time.Instant

fun main() {
    val dm = displayMessage { cycle() }
    val dm1 = displayMessage { cycle() }
    val dm2 = displayMessage { cycle() }
    val dm3 = displayMessage { cycle() }
    println("dm - $dm, dm1 - $dm1, dm2 - $dm2, dm3 - $dm3")
}
fun displayMessage(mes: () -> Unit): Long {
    val time1 = Instant.now()
    mes()
    val time2 = Instant.now()
    return time2.epochSecond - time1.epochSecond
}
fun cycle(){ var num = 100000; while (num != 0){ num-=1; print("nuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuum") }; println("") }