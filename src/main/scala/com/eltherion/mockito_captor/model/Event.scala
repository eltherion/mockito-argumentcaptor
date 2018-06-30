package com.eltherion.mockito_captor.model

sealed trait Event

case object EventA        extends Event
case object EventB        extends Event
case object EventC        extends Event
case object EventUnknown  extends Event