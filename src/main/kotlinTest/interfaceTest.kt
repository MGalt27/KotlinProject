fun main(){
    val rectangle = Rectangle(4.0F, 6.0F)
    rectangle.show()

    println("********************")

    val circle = Circle(3.0F)
    circle.show()

    println("********************")

    val triangle = Triangle(3.0F, 4.0F, 5.0F)
    triangle.show()
}

interface Shape{
    fun getArea(): Float{
        val area = 0.0F
        return area
    }
    fun getPerimeter(): Float{
        val perimeter = 0.0F
        return perimeter
    }
}

class Rectangle(length: Float, width: Float): Shape{

    val length = length
    val width = width

    override fun getArea(): Float {
        val area = length * width
        return area
    }

    override fun getPerimeter(): Float {
        val perimeter = (length + width) * 2
        return perimeter
    }

    fun show(){
        println("Rectangle with length $length and width $width:\n" +
                "Area - ${getArea()}\n" +
                "Perimeter - ${getPerimeter()}\n")
    }

}
class Circle(radius: Float): Shape{

    val radius = radius

    override fun getArea(): Float {
        val area = ((radius * Math.PI) * (radius * Math.PI)).toFloat()
        return area
    }

    override fun getPerimeter(): Float {
        val perimeter = (2 * Math.PI * radius).toFloat()
        return  perimeter
    }

    fun show(){
        println("Circle with radius $radius:\n" +
                "Area - ${getArea()}\n" +
                "Perimeter - ${getPerimeter()}\n")
    }
}
class Triangle(_side1: Float, _side2: Float, _side3: Float) : Shape{

    val side1 = _side1
    val side2 = _side2
    val side3 = _side3


    override fun getArea(): Float {
        val area = (0.5 * side1 * side2).toFloat()
        return area
    }

    override fun getPerimeter(): Float {
        val perimeter = (side1 + side2 + side3)
        return  perimeter
    }

    fun show(){
        println("Circle with sides $side1, $side2 and $side3:\n" +
                "Area - ${getArea()}\n" +
                "Perimeter - ${getPerimeter()}\n")
    }

}