package com.eltherion.mockito_captor.service

import com.eltherion.mockito_captor.model._

object EventCreator {
  def fromMessage: String => Event = {
    case "messageA" => EventA
    case "messageB" => EventB
    case "messageC" => EventC
    case _          => EventUnknown
  }
}
