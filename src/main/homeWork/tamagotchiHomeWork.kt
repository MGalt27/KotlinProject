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
    private val red = "\u001B[31m"
    private val green = "\u001B[32m"
    private val yellow = "\u001B[33m"
    private val blue = "\u001B[34m"

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
                    println("${yellow}done")
                }
                (choise == 2) -> {
                    mood += 20
                    energy -= 40
                    liveTimeHour+=1
                    println("${yellow}done")
                }
                (choise == 3) -> {
                    mood += 50
                    energy -= 90
                    liveTimeHour+=1
                    println("${yellow}done")
                }
            }
        }
        else{
            println("${red}$name is dead")
        }
    }

    private fun toilet(){
        statusAlive()
        if (statusAlive == "Alive"){
            statusToilet -= 30
            statusHungry += 5
            mood += 10
            liveTimeHour+=1
            println("${yellow}done")
        }
        else{
            println("$red$name is dead")
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
            println("$red$name is dead")
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
            println("${yellow}done")
        }
        else{
            println("$red$name is dead")
        }
    }

    private fun animalCard(){
        statusAlive()
        when{
            (statusAlive == "Alive") -> {
                println("${yellow}***********************\n" +
                        "${green}name - ${yellow}$name\n" +
                        "${green}animalType - ${yellow}$animalType\n" +
                        "${green}liveTimeHour - ${yellow}$liveTimeHour\n" +
                        "${green}statusHungry - ${yellow}$statusHungry\n" +
                        "${green}statusToilet - ${yellow}$statusToilet\n" +
                        "${green}mood - ${yellow}${mood}\n" +
                        "${green}energy - ${yellow}${energy}\n" +
                        "${green}statusAlive - ${green}$statusAlive\n" +
                        "${yellow}***********************\n")
            }
            else -> {
                println("${yellow}***********************\n" +
                        "${green}name - ${yellow}$name\n" +
                        "${green}animalType - ${yellow}$animalType\n" +
                        "${green}liveTimeHour - ${yellow}$liveTimeHour\n" +
                        "${green}statusHungry - ${yellow}$statusHungry\n" +
                        "${green}statusToilet - ${yellow}$statusToilet\n" +
                        "${green}mood - ${yellow}${mood}\n" +
                        "${green}energy - ${yellow}${energy}\n" +
                        "${green}statusAlive - ${red}$statusAlive\n" +
                        "${green}reason death - ${red}$reasonDeath\n" +
                        "${yellow}***********************\n")
            }
        }

    }

    fun startGame(){
        var statusGame = true
        println("${blue}The game is on\n" +
                "${blue}To exit the game, enter 0")
        while(statusGame){
            println("${blue}************************\n" +
                    "${blue}Game menu:\n" +
                    "${blue}animal card - 1\n" +
                    "${blue}eat - 2\n" +
                    "${blue}toilet - 3\n" +
                    "${blue}sleep - 4\n" +
                    "${blue}game - 5\n" +
                    "${blue}exit - 0\n" +
                    "${blue}************************\n")
            print("${yellow}choise - "); var choise = readln().toInt()
            when{
                (choise == 1) -> {
                    var statusAnimalCard = true
                    while (statusAnimalCard){
                        animalCard()
                        println("${blue}back - 0")
                        print("${yellow}choise - "); var choiseAnimalCard = readln().toInt()
                        if (choiseAnimalCard == 0){
                            statusAnimalCard = false
                        }
                    }
                }
                (choise == 2) -> {
                    var statusEat = true
                    while (statusEat){
                        println("${blue}1 - firstFood:\n" +
                                "   ${blue}statusHungry -= 10\n" +
                                "   ${blue}statusToilet += 5\n" +
                                "\n" +
                                "${blue}2 - secondFood:\n" +
                                "   ${blue}statusHungry -= 20\n" +
                                "   ${blue}statusToilet += 15\n" +
                                "\n" +
                                "${blue}3 - thirdFood:\n" +
                                "   ${blue}statusHungry -= 30\n" +
                                "   ${blue}statusToilet += 20\n")
                        println("${blue}back - 0")
                        print("${yellow}choise - "); var choiseEat = readln().toInt()
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
                        println("${blue}1 - firstGame:\n" +
                                "   ${blue}mood += 10\n" +
                                "   ${blue}energy -= 10\n" +
                                "\n" +
                                "${blue}2 - secondGame:\n" +
                                "   ${blue}mood += 20\n" +
                                "   ${blue}energy -= 40\n" +
                                "\n" +
                                "${blue}3 - thirdGame:\n" +
                                "   ${blue}mood += 50\n" +
                                "   ${blue}energy -= 90\n")
                        println("${blue}back - 0")
                        print("${yellow}choise - "); var choiseGame = readln().toInt()
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
                    println("${red}game is over")
                }
            }
        }
    }

}
