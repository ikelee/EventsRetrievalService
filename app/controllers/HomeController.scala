package controllers

import javax.inject._

import models.RetrievalEventsResponse
import play.api.libs.json.Json
import play.api.mvc._
import services.FacebookEventService
import services.InternalServicesError.GetEventsError

import scala.concurrent.ExecutionContext.Implicits.global

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, eventService: FacebookEventService) extends AbstractController(cc) {

  def status = Action {
    Ok("Hi")
  }

  def getEvents: Action[AnyContent] = Action.async { implicit request =>
    val memberId = request.getQueryString("memberId").map(_.toInt).getOrElse(0)
    eventService
      .getEvents(memberId = memberId, location = "123,123")
      .map(toHttpResults)
  }

  private def toHttpResults(response: Either[GetEventsError, RetrievalEventsResponse]): Result =
    response match {
      case Right(eventsResponse) => Ok(Json.toJson(eventsResponse))
      case _                     => InternalServerError(ControllerError.UnknownServerError)
    }
}
