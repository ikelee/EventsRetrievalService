package services

object InternalServicesError {
  sealed trait GetEventsError

  case object unknownError extends GetEventsError

}
