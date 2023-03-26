fun main(){
    print("Year - ");
    val year = readln().toInt();
    when{
        (year % 100 == 0) -> println(year / 100);
        (year >= 0) -> println((year / 100) + 1);
        else -> println("Error")
    }
}