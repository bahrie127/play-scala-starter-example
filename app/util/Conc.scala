package util

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object Conc {

    var waitTime: FiniteDuration = 3.seconds


    /**
      * Helper to easy get async result sync.
      * @param qf future query/get.
      * @tparam T result type.
      * @return
      */
    def sync[T](qf:Future[T]): T = {
        Await.result(qf, waitTime)
    }

}
