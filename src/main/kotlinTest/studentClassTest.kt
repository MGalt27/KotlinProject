package studentClassTest

fun main(){
 /* val MaksimGrade = listOf<Int>(5, 5, 5, 2, 2, 3, 4, 4, 4)
    val Maksim = Student("Maksim", 17, 2, MaksimGrade)
    Maksim.studentCard()
    println("-----------------------------------------------------------------")
    val Igor = Student("Igor"); Igor.studentCard()
    println("-----------------------------------------------------------------")
    val Victor = Student("Victor", 22); Victor.studentCard()
    println("-----------------------------------------------------------------")
    val gr = readln()
    val grList = gr.split(" ").map(String::toInt)
    val Dan = Student("Dan", 19, 4, grList); Dan.studentCard()
    */
    val MaksimGrade = listOf<Int>(5, 5, 5, 2, 2)
    val Maksim = Student("Maksim", 17, 2, MaksimGrade)
    val IgorAverage = listOf<Int>(5, 4, 3, 2, 5)
    val Igor = Student("Igor", 19, 4, IgorAverage)

    val groupMath = Group("math group")
    groupMath.addStudent(Maksim)
    groupMath.addStudent(Igor)

    val VictorGrade = listOf<Int>(5, 5, 5, 5, 5)
    val Victor = Student("Victor", -18, 3, VictorGrade)
    val AlexAverage = listOf<Int>(3, 2, 3, 2, 5)
    val Alex = Student("Alex", 16, -2, AlexAverage)

    val groupBiologic = Group("Biologic group")
    groupBiologic.addStudent(Victor)
    groupBiologic.addStudent(Alex)

    val universityName = University("BFU")
    universityName.addGroup(groupMath)
    universityName.addGroup(groupBiologic)

    universityName.universityCard()
}

class Student(_name: String){
    private val name = _name
    private var age = 16
        set(value){
            if(value in 16..110)
                field = value
            else {println("Student - $name\n" +
                    "age must be in 16..110\n" +
                    "//////////////////////////////")}
        }
    private var course = 1
        set(value){
            if (value in 1..5){
                field = value
            }
            else {println("Student - $name\n" +
                    "course must be in 1..5\n" +
                    "///////////////////////////////")}
        }
    private var grades = mutableListOf<Int>()

    constructor(_name: String, _age: Int): this(_name){
        age = _age
    }
    constructor(_name: String, _age: Int, _course: Int): this(_name, _age){
        course = _course
    }
    constructor(_name: String, _age: Int, _course: Int, _grades: List<Int>): this(_name, _age, _course){
        grades = _grades.toMutableList()
    }

    fun addGrade(grade: Int){
        grades.add(grade)
    }

    fun getAverageGrade(): String {
        val averageList: Float = (grades.sum()).toFloat() / grades.size
        val formatGrade = "%.2f".format(averageList)
        return (formatGrade)
    }

    fun studentCard(){
        println("name - $name\n" +
                "age - $age\n" +
                "course - $course\n" +
                "grades - $grades\n" +
                "average grade - ${getAverageGrade()}")
    }

}

class Group(name: String){
    private val students = mutableListOf<Student>()
    private val groupName = name

    fun addStudent(student: Student){
        students.add(student)
    }

    fun getGroupAverage(): String {
        var sum = 0.0F
        for (stud in students) {
            sum += ((stud.getAverageGrade()).replace(",", ".")).toFloat()
        }
        sum /= students.size
        return ("%.2f".format(sum)).replace(",", ".")
    }

    fun groupCard(){
        println("group name - $groupName\n" +
                "group average - ${getGroupAverage()}")

        for (stud in 0 until students.size){
            println("-------------------------------------")
            println("Student number - ${stud + 1}")
            students[stud].studentCard()
        }
    }
}

class University(name: String){
    private val groups = mutableListOf<Group>()
    private val universityName = name

    fun addGroup(group: Group){
        groups.add(group)
    }

    fun getUniversityAverage(): String{
        var sum = 0.0F
        for (group in groups){
                sum += group.getGroupAverage().replace(",", ".").toFloat()
        }
        sum /= groups.size
        return ("%.2f".format(sum)).replace(",", ".")
    }


    fun universityCard(){
        println("University name - $universityName\n" +
                "University average - ${getUniversityAverage()}")
        for (group in 0 until groups.size){
            println("************************************")
            println("group number - ${group + 1}")
            groups[group].groupCard()
        }
    }
}