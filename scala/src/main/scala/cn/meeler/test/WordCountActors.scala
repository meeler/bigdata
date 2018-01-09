package cn.meeler.test

import scala.actors.{Actor, Future}
import scala.collection.mutable.{HashSet, ListBuffer}
import scala.io.Source

/**
  * Created by meeler on 2018/1/9.
  */
object WordCountActors {
  def main(args: Array[String]): Unit = {
    var replySet = new HashSet[Future[Any]]()
    val resultList = new ListBuffer[ResultTask]()
    val actorList = new ListBuffer[Actor]()
    var filePaths = Array[String]("/Users/meeler/wc/words.txt", "/Users/meeler/wc/words.log")
    for (filePath <- filePaths) {
      var actor = new Task()
      var reply = actor.start() !! SubmitTask(filePath)
      replySet += reply
      actorList += actor
    }
    while (replySet.size > 0) {
      var toComputer = replySet.filter(_.isSet)
      for (elem <- toComputer) {
        var result = elem.apply().asInstanceOf[ResultTask]
        resultList += result
        replySet -= elem
      }
      Thread.sleep(500)
    }

    for (elem <- actorList) {
      elem ! StopTask
    }
    var finalResult = resultList.flatMap(_.result).groupBy(p => p._1).map(r => (r._1, r._2.map(_._2).sum))
    println(finalResult.toList)

  }

  case class SubmitTask(filePath: String)

  case class ResultTask(result: Map[String, Int])

  case object StopTask

  class Task extends Actor {
    override def act(): Unit = {
      loop {
        react {
          case SubmitTask(filePath) => {
            //            var ResultTask = Source.fromFile(filePath).getLines().flatMap(_.split(" ")).map((_,1)).groupBy(_._1).map(p=>(p._1,p._2.map(_._2).sum))
            var results = Source.fromFile(filePath).getLines().flatMap(_.split(" ")).map((_, 1)).toList.groupBy(_._1).map(p => (p._1, p._2.map(_._2).sum))
            sender ! ResultTask(results)
          }
          case StopTask => {
            exit()
          }
        }
      }
    }
  }

}
