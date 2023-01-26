package com.example.test.service

import com.example.test.model.Event
import com.example.test.repository.EventRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class EventServiceTest {

  @InjectMocks
  lateinit var eventService: EventService

  @Mock
  lateinit var  eventRepository: EventRepository

  val jsonString = File("./src/test/resources/event.json").readText(Charsets.UTF_8)
  val eventMock = Gson().fromJson(jsonString, Event::class.java)

  @Test
  fun saveEventCorrect(){
    Mockito.`when`(eventRepository.save(Mockito.any(Event::class.java))).thenReturn(eventMock)
    val response = eventService.save(eventMock)
    Assertions.assertEquals(response?.id, eventMock.id)
  }

  @Test
  fun saveEventWhenDescriptionIsBlank(){

    Assertions.assertThrows(Exception::class.java) {
      eventMock.apply { description=" "}
      Mockito.`when`(eventRepository.save(Mockito.any(Event::class.java))).thenReturn(eventMock)
      eventService.save(eventMock)
    }

  }
}
