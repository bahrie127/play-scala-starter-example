package infra

import com.outr.arango._
import com.outr.arango.managed._
import com.typesafe.config.{Config, ConfigFactory}
import io.youi.net.URL
import util.Conc._

object DB {

    val conf = ConfigFactory.load().getConfig("db")
    var dbName = conf.getString("name")
    var creds = Credentials(conf.getString("user"),
        conf.getString("password"))

    var sess: ArangoSession = _

    lazy val init: Unit = {
        sess = sync({
            val url = conf.getString("host") + ":" + conf.getString("port") match {
                case tail if tail.startsWith("http://") => tail
                case tail => "http://" + tail
            }
            val arango = new Arango(URL(url))
            arango.session(Some(creds))
        })
    }

    lazy val raw: ArangoDB = {
        init
        sess.db(dbName)
    }


    object Helpers {

        implicit def strToValue(value: String): Value = StringValue(value)
        implicit def intToValue(value: Int): Value = IntValue(value)
        implicit def longToValue(value: Long): Value = LongValue(value)
        implicit def doubleToValue(value: Double): Value = DoubleValue(value)

        def query(q:String, params:(String, Value)*) = {
            if (params.isEmpty) Query(q, Map.empty)
            else Query(q, params.toMap)
        }
    }

}