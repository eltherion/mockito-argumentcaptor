package com.eltherion.mockito_captor.service

import com.eltherion.mockito_captor.model._
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.{atLeastOnce, verify, when}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{Assertion, AsyncWordSpec, Matchers}

import scala.concurrent.Future
class EventPersistorImplSpec extends AsyncWordSpec with Matchers with MockitoSugar {

  private val mockedEventRepo = mock[EventRepository]
  private val captor: ArgumentCaptor[Event] = ArgumentCaptor.forClass(classOf[Event])
  when(mockedEventRepo.save(any[Event])).thenReturn(Future.successful())

  private val testedEventPersistorImpl = new EventPersistorImpl(mockedEventRepo)

  "An EventPersistorImpl" can {

    "persist an event for message" should {

      "save event correctly for specific message" in {

        checkPassedEvent(message = "messageA",    expectedEvent = EventA)
        checkPassedEvent(message = "messageB",    expectedEvent = EventB)
        checkPassedEvent(message = "messageC",    expectedEvent = EventC)
        checkPassedEvent(message = "someMessage", expectedEvent = EventUnknown)
      }
    }
  }

  private def checkPassedEvent(message: String, expectedEvent: Event) = {
    testedEventPersistorImpl
      .persistFor(message)
      .map { result =>
        result shouldBe (())
        verify(mockedEventRepo, atLeastOnce)
          .save(captor.capture())
        val passedEvent = captor.getValue
        passedEvent shouldBe expectedEvent
      }
  }
}
