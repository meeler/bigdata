package cn.meeler.test

/**
  * Created by meeler on 2018/1/9.
  */
object SingletonDemo {

  def main(args: Array[String]): Unit = {
      var s =  SessionFactory.session
      var ss = SessionFactory.session
      println(s)
      println(ss)
  }


}

object SessionFactory{
    var session = new Session();
}


class Session{

}