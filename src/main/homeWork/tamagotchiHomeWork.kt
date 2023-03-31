fun main(){

    print("Input your animal name - "); val animalName = readln()
    print("Input type your animal - "); val animalType = readln()

    val tamagotchi = Tamagotchi(animalName, animalType)
    tamagotchi.startGame()

}

class Tamagotchi(_name:String, _animalType:String){

    private val name = _name
    private val animalType = _animalType
    private var liveTimeHour = 0
    private var statusHungry = 50
    private var statusToilet = 50
    private var mood = 100
    private var energy = 100
    private var statusAlive = "Alive"
    private var reasonDeath = ""

    //private val reset = "\u001B[0m"
    private val colorLineRed = "\u001B[31m"
    private val colorLineGreen = "\u001B[32m"
    private val colorLineYellow = "\u001B[33m"
    private val colorLineBlue = "\u001B[34m"

    private fun statusAlive(){
        when{
            (liveTimeHour >= 50) -> {
                statusAlive = "Dead"
                reasonDeath = "age"
            }
            (statusHungry <= 0) -> {
                statusAlive = "Dead"
                reasonDeath = "statusHungry"
            }
            (statusToilet >= 100) -> {
                statusAlive = "Dead"
                reasonDeath = "statusToilet"
            }
            (mood <= 0) -> {
                statusAlive = "Dead"
                reasonDeath = "mood"
            }
            (energy <= 0) -> {
                statusAlive = "Dead"
                reasonDeath = "energy"
            }
            else -> {}
        }
        when{
            (statusHungry >= 100) -> statusHungry = 100
            (statusToilet <= 0) -> statusToilet = 0
            (energy >= 100) -> energy = 100
            (mood >= 100) -> mood = 100
            else -> {}
        }
    }

    private fun game(choise: Int){
        statusAlive()
        if (statusAlive == "Alive"){
            when{
                (choise == 1) -> {
                    mood += 10
                    energy -= 10
                    liveTimeHour+=1
                    println("${colorLineYellow}done")
                }
                (choise == 2) -> {
                    mood += 20
                    energy -= 40
                    liveTimeHour+=1
                    println("${colorLineYellow}done")
                }
                (choise == 3) -> {
                    mood += 50
                    energy -= 90
                    liveTimeHour+=1
                    println("${colorLineYellow}done")
                }
            }
        }
        else{
            println("${colorLineRed}$name is dead")
        }
    }

    private fun toilet(){
        statusAlive()
        if (statusAlive == "Alive"){
            statusToilet -= 30
            statusHungry += 5
            mood += 10
            liveTimeHour+=1
            println("${colorLineYellow}done")
        }
        else{
            println("$colorLineRed$name is dead")
        }
    }

    private fun eat(choise: Int) {
        statusAlive()
        if (statusAlive == "Alive") {
            when{
                (choise == 1) -> {
                    statusHungry -= 10
                    statusToilet += 5
                    liveTimeHour+=1
                    return println("done")
                }
                (choise == 2) -> {
                    statusHungry -= 20
                    statusToilet += 15
                    liveTimeHour+=1
                    return println("done")
                }
                (choise == 3) -> {
                    statusHungry -= 30
                    statusToilet += 20
                    liveTimeHour+=1
                    return println("done")
                }
            }
        }
        else{
            println("$colorLineRed$name is dead")
        }
    }

    private fun sleep(){
        statusAlive()
        if (statusAlive == "Alive"){
            statusToilet += 30
            statusHungry += 25
            mood += 20
            energy +=100
            liveTimeHour+=1
            println("${colorLineYellow}done")
        }
        else{
            println("$colorLineRed$name is dead")
        }
    }

    private fun animalCard(){
        statusAlive()
        when{
            (statusAlive == "Alive") -> {
                println("${colorLineYellow}***********************\n" +
                        "${colorLineGreen}name - ${colorLineYellow}$name\n" +
                        "${colorLineGreen}animalType - ${colorLineYellow}$animalType\n" +
                        "${colorLineGreen}liveTimeHour - ${colorLineYellow}$liveTimeHour\n" +
                        "${colorLineGreen}statusHungry - ${colorLineYellow}$statusHungry\n" +
                        "${colorLineGreen}statusToilet - ${colorLineYellow}$statusToilet\n" +
                        "${colorLineGreen}mood - ${colorLineYellow}${mood}\n" +
                        "${colorLineGreen}energy - ${colorLineYellow}${energy}\n" +
                        "${colorLineGreen}statusAlive - ${colorLineGreen}$statusAlive\n" +
                        "${colorLineYellow}***********************\n")
            }
            else -> {
                println("${colorLineYellow}***********************\n" +
                        "${colorLineGreen}name - ${colorLineYellow}$name\n" +
                        "${colorLineGreen}animalType - ${colorLineYellow}$animalType\n" +
                        "${colorLineGreen}liveTimeHour - ${colorLineYellow}$liveTimeHour\n" +
                        "${colorLineGreen}statusHungry - ${colorLineYellow}$statusHungry\n" +
                        "${colorLineGreen}statusToilet - ${colorLineYellow}$statusToilet\n" +
                        "${colorLineGreen}mood - ${colorLineYellow}${mood}\n" +
                        "${colorLineGreen}energy - ${colorLineYellow}${energy}\n" +
                        "${colorLineGreen}statusAlive - ${colorLineRed}$statusAlive\n" +
                        "${colorLineGreen}reason death - ${colorLineRed}$reasonDeath\n" +
                        "${colorLineYellow}***********************\n")
            }
        }

    }

    fun startGame(){
        var statusGame = true
        println("${colorLineBlue}The game is on\n" +
                "${colorLineBlue}To exit the game, enter 0")
        while(statusGame){
            println("${colorLineBlue}************************\n" +
                    "${colorLineBlue}Game menu:\n" +
                    "${colorLineBlue}animal card - 1\n" +
                    "${colorLineBlue}eat - 2\n" +
                    "${colorLineBlue}toilet - 3\n" +
                    "${colorLineBlue}sleep - 4\n" +
                    "${colorLineBlue}game - 5\n" +
                    "${colorLineBlue}exit - 0\n" +
                    "${colorLineBlue}************************\n")
            print("${colorLineYellow}choise - "); var choise = readln().toInt()
            when{
                (choise == 1) -> {
                    var statusAnimalCard = true
                    while (statusAnimalCard){
                        animalCard()
                        println("${colorLineBlue}back - 0")
                        print("${colorLineYellow}choise - "); var choiseAnimalCard = readln().toInt()
                        if (choiseAnimalCard == 0){
                            statusAnimalCard = false
                        }
                    }
                }
                (choise == 2) -> {
                    var statusEat = true
                    while (statusEat){
                        println("${colorLineBlue}1 - firstFood:\n" +
                                "   ${colorLineBlue}statusHungry -= 10\n" +
                                "   ${colorLineBlue}statusToilet += 5\n" +
                                "\n" +
                                "${colorLineBlue}2 - secondFood:\n" +
                                "   ${colorLineBlue}statusHungry -= 20\n" +
                                "   ${colorLineBlue}statusToilet += 15\n" +
                                "\n" +
                                "${colorLineBlue}3 - thirdFood:\n" +
                                "   ${colorLineBlue}statusHungry -= 30\n" +
                                "   ${colorLineBlue}statusToilet += 20\n")
                        println("${colorLineBlue}back - 0")
                        print("${colorLineYellow}choise - "); var choiseEat = readln().toInt()
                        when{
                            (choiseEat == 1) -> { eat(1) }
                            (choiseEat == 2) -> { eat(2) }
                            (choiseEat == 3) -> { eat(3) }
                            (choiseEat == 0) -> { statusEat = false}
                        }
                    }
                }
                (choise == 3) -> { toilet() }
                (choise == 4) -> { sleep() }
                (choise == 5) -> {
                    var statusGame = true
                    while (statusGame){
                        println("${colorLineBlue}1 - firstGame:\n" +
                                "   ${colorLineBlue}mood += 10\n" +
                                "   ${colorLineBlue}energy -= 10\n" +
                                "\n" +
                                "${colorLineBlue}2 - secondGame:\n" +
                                "   ${colorLineBlue}mood += 20\n" +
                                "   ${colorLineBlue}energy -= 40\n" +
                                "\n" +
                                "${colorLineBlue}3 - thirdGame:\n" +
                                "   ${colorLineBlue}mood += 50\n" +
                                "   ${colorLineBlue}energy -= 90\n")
                        println("${colorLineBlue}back - 0")
                        print("${colorLineYellow}choise - "); var choiseGame = readln().toInt()
                        when{
                            (choiseGame == 1) -> { game(1) }
                            (choiseGame == 2) -> { game(2) }
                            (choiseGame == 3) -> { game(3) }
                            (choiseGame == 0) -> { statusGame = false}
                        }
                    }
                }
                (choise == 0) -> {
                    statusGame = false
                    println("${colorLineRed}game is over")
                }
            }
        }
    }

}
