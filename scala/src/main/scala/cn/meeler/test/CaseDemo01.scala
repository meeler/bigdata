package cn.meeler.test

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Created by meeler on 2018/1/9.
  */
object CaseDemo01 extends App {
  var array = ArrayBuffer("YoshizawaAkiho", "YuiHatano", "AoiSola")
  array(Random.nextInt(array.length)) match {
    case "YoshizawaAkiho" => {
      println("吉泽老师")
    }
    case "YuiHatano" => {
      println("波多老师")
    }
    case "AoiSola" => {
      println("苍老师")
    }
  }


}
