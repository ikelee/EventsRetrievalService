package models

import play.api.libs.json.{Json, Writes}

case class Events(
    location: Int,
    eventId: String,
    InvitedCount: Int,
    GoingCount: Int
)

object Events{
  implicit val writeEvents: Writes[Events] = Json.writes[Events]

}
