//interface CardStudent{
//    var name: String
//    var age: Int
//    var course: Int
//    var grades: MutableList<Int>
//}
//
//class Student: CardStudent{
//    override var name: String
//        get() = TODO("Not yet implemented")
//        set(value) {}
//    override var age: Int
//        get() = TODO("Not yet implemented")
//        set(value) {}
////        set(value){
////            if(value in 16..110)
////                field = value
////            else {println("Student - $name\n" +
////                    "age must be in 16..110\n" +
////                    "//////////////////////////////")}
////        }
//    override var course: Int
//        get() = TODO("Not yet implemented")
//        set(value) {}
////        set(value){
////            if (value in 1..5){
////                field = value
////            }
////            else {println("Student - $name\n" +
////                    "course must be in 1..5\n" +
////                    "///////////////////////////////")}
////        }
//    override var grades: MutableList<Int>
//        get() = TODO("Not yet implemented")
//        set(value) {}
//
////    constructor(_name: String, _age: Int): this(_name){
////        age = _age
////    }
////    constructor(_name: String, _age: Int, _course: Int): this(_name, _age){
////        course = _course
////    }
////    constructor(_name: String, _age: Int, _course: Int, _grades: List<Int>): this(_name, _age, _course){
////        grades = _grades.toMutableList()
////    }
//
//    fun addGrade(grade: Int){
//        grades.add(grade)
//    }
//
//    fun getAverageGrade(): String {
//        val averageList: Float = (grades.sum()).toFloat() / grades.size
//        val formatGrade = "%.2f".format(averageList)
//        return (formatGrade)
//    }
//
//    fun studentCard(){
//        println("name - $name\n" +
//                "age - $age\n" +
//                "course - $course\n" +
//                "grades - $grades\n" +
//                "average grade - ${getAverageGrade()}")
//    }
//
//}
//
//fun main(){
//    var mak = Student()
//    ////////////mak.studentCard()
//    mak.age = 15
//    mak.course =8
//    mak.name = "Makism"
//    mak.studentCard()
//}