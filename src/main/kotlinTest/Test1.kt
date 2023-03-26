fun main(){
    var table = Array(3, {Array(3, {0})})
    table[0] = arrayOf(1, 2, 3)
    table[1] = arrayOf(1, 2, 3)
    table[2] = arrayOf(1, 2, 3)

    for (row in table){
        for (cell in row){
            print("$cell ")
        }
        println()
    }

    for (row in 1..9){
        for (coll in 1..9){
            print("$row * $coll = ${row * coll}\t")
        }
        println()
    }
}
