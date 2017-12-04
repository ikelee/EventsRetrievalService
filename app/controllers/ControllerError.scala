package controllers

import play.api.http.{ContentTypeOf, ContentTypes, Writeable}
import play.api.libs.json.{JsPath, Writes, Json}
import play.api.libs.functional.syntax._
import play.api.mvc.Codec

import scala.concurrent.ExecutionContext.Implicits.global


trait ControllerError {
  val code: Int
  val message: String
}

object ControllerError {
  def unapply(arg: ControllerError): Option[(Int, String)] =
    Some((arg.code, arg.message))

  implicit val writeJson: Writes[ControllerError] = (
    (JsPath \ "code").write[Int] and (JsPath \ "message").write[String]
    )(unlift(ControllerError.unapply))

  implicit def contentTypeControllerError(
                                           implicit codec: Codec): ContentTypeOf[ControllerError] =
    ContentTypeOf[ControllerError](Some(ContentTypes.JSON))

  implicit def writeableOfControllerError(
                                           implicit codec: Codec): Writeable[ControllerError] =
    Writeable(error => codec.encode(Json.toJson(error).toString))

  case object UnknownServerError extends ControllerError {
    override val code: Int = 4001
    override val message: String = "We don't know what happened"
  }
}
