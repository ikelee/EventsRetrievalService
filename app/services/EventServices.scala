package services

import com.google.inject.Singleton
import models.RetrievalEventsResponse
import services.InternalServicesError.{GetEventsError, unknownError}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class FacebookEventService {
  def getEvents(memberId: Int, location: String)(implicit ec: ExecutionContext)
    : Future[Either[GetEventsError, RetrievalEventsResponse]] = {
    Future(Left(unknownError))
  }
}
