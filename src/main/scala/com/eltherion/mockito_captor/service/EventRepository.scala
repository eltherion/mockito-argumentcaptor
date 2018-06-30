package com.eltherion.mockito_captor.service

import com.eltherion.mockito_captor.model.Event

import scala.concurrent.Future

trait EventRepository {
  def save(event: Event): Future[Unit]
}
