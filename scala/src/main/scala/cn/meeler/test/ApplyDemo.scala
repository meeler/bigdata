package cn.meeler.test



/**
  * Created by meeler on 2018/1/9.
  */
object ApplyDemo {
  def apply(): Unit ={
    println("hello I am meeler")
  }

  def apply(name:String,age:Int):ApplyDemo={
     new ApplyDemo(name,age)
  }
}
class ApplyDemo{
  var name:String= _
  var age:Int = _
  def this(name:String,age:Int){
    this
    this.name= name
    this.age = age
  }
}
object applyTest{
  def main(args: Array[String]): Unit = {
    var app = ApplyDemo()
//    println(app)
    var apps = ApplyDemo("lisi",22)
    println(apps)
  }
}