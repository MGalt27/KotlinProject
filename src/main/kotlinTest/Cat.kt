import java.time.Instant

class Cat(private val name: String,
          private var age: Int,
          private var weight: Int,
          private val voice: String){

    private var statusHungry = 5
    private var statusToilet = 5
    private var statusAlive = "alive"


    fun eat(){
        statusHungry--
    }

    fun toilet(){
        weight--
        statusToilet --
        statusHungry ++
        if (weight == 0){
            statusAlive = "dead"
        }
    }

    fun sleep(){
        statusHungry++
        age++
    }


    private fun death(): String{
        if ((age > 20) || (weight > 15) || (statusToilet == 10) || (statusHungry >= 10)){
            statusAlive = "dead"
            return statusAlive
        }
        return ("alive")
    }

    fun catCard(){
        println("*************************\n" +
                "name - $name\n" +
                "age - $age\n" +
                "weight - $weight\n" +
                "voice - $voice\n" +
                "statusHungry - $statusHungry\n" +
                "statusToilet - $statusToilet\n" +
                "statusAlive - ${death()}\n" +
                "***************************\n")
    }
}