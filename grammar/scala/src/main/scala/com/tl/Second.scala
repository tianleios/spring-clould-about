package com.tl

object Second {

  def main(args: Array[String]): Unit = {
    println(10)

    val count = 0

    def test(x: Int): Int = x + x

    val fun = (x: Int, y: Int) => x + y

    val fun2 = test _

    println(fun2(2))

    val counts: Array[String] = Array("1", "2", "3")
    println(counts)
    val peopleMap = Map(
      "name" -> "tianlei",
      "age" -> 20
    )

    def matchT(x: Int): Any = count match {
      case 0 => 1
    }

    List(1,2,3).map(_*2)


  }

}
