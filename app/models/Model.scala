package models

import com.outr.arango.DocumentOption
import io.circe.{Decoder, Encoder}
import infra._
import util.Conc._
import infra.DB.Helpers._

trait Model {
    this: DocumentOption =>

    def id:String = _id.getOrElse("")
    def key:String = _key.getOrElse("")

}

//abstract class BaseDao[T] {
//
//    implicit val _encoder: Encoder[T]
//    implicit val _decoder: Decoder[T]
//
//    val collectionName:String
//    lazy val db = G.engine.db
//    lazy val col = db.raw.collection(collectionName)
//
//    def getList(offset:Int, limit:Int):List[T]
//
//    def getByKey(key: String): Option[T]
//
//    def getCount():Long = {
//        sync(G.engine.db.raw.collection(collectionName).count()).count
//    }
//
//    def delete(key:String, async:Boolean=true) = {
//        def q = G.engine.db.raw.cursor(
//            query(s"FOR a IN $collectionName FILTER a._key == @key REMOVE {_key: @key} IN $collectionName", "key" -> key))
//        if (async) q else sync(q)
//    }
//
//    def clear(async:Boolean=true) = {
//        if (async){
//            G.engine.db.raw.collection(collectionName).truncate()
//        }else{
//            sync(G.engine.db.raw.collection(collectionName).truncate())
//        }
//    }

//}