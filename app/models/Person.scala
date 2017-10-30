package models

import util.Conc._
import infra._
import com.outr.arango.{ArangoCollection, DocumentOption, _}
import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto._
import infra.DB.Helpers._
import infra.DB._
case class Person(name:String,
                 address: String,
                 phone: String,
                 _key: Option[String] = None,
                 _id: Option[String] = None,
                 _rev: Option[String] = None) extends Model with DocumentOption {
}


object Person {

     implicit val _encoder: Encoder[Person] = deriveEncoder[Person]
     implicit val _decoder: Decoder[Person] = deriveDecoder[Person]
     val collectionName: String = "person"

     def getList(offset: Int, limit: Int): List[Person] =

        sync(DB.raw.cursor[Person](query("FOR o IN person  RETURN o"))).result

     def getByKey(key: String): Option[Person] =
        sync(DB.raw.cursor[Person](query("FOR o IN person  RETURN o"))).result.headOption

    def getList: List[Person] =
        sync(DB.raw.cursor[Person](query("FOR a IN person SORT a.name ASC RETURN a"))).result


}