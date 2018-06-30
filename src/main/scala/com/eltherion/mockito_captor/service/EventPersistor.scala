package com.eltherion.mockito_captor.service

import com.eltherion.mockito_captor.service.EventCreator.fromMessage

import scala.concurrent.Future

trait EventPersistor {
  def persistFor(message: String): Future[Unit]
}

class EventPersistorImpl(eventRepository: EventRepository) extends EventPersistor {
  override def persistFor(message: String): Future[Unit] = {
    val event = fromMessage(message)
    eventRepository.save(event)
  }
}
