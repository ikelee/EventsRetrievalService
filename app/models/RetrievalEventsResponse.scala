package models

import play.api.libs.json.{Json, Writes}

case class RetrievalEventsResponse(
    events: List[Events],
    location: Option[String]
)

object RetrievalEventsResponse {
  implicit val writeRetrievalEventsResponse: Writes[RetrievalEventsResponse] =
    Json.writes[RetrievalEventsResponse]
}
