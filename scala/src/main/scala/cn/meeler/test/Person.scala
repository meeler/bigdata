package cn.meeler.test

/**
  * Created by meeler on 2018/1/9.
  */
  class Person {
  var id = "9527"
  var name: String = "zhangsan"
//  private[this]  var age: Int = 12
  var age: Int = 12

  def this(id: String, name: String, age: Int) {
    this
    this.name = name
    this.age = age
    this.id = id
  }
}

object Person {

  def main(args: Array[String]): Unit = {
    var person = new Person();
    println(person.age)
    println(person.name)
    person.name = "lisi"
    println(person.name)
    //    person.id="915"

    var person2 = new Person("915", "lisi", 20)
    var p2name = person2.name
    var p2id = person2.id
    var p2age = person2.age
    println(s"姓名：$p2name id :$p2id 年龄:$p2age")


  }

}
