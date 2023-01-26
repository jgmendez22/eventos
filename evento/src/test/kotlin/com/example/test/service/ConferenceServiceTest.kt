package com.example.test.service

import com.example.test.model.Conference
import com.example.test.model.Event
import com.example.test.repository.ConferenceRepository
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
class ConferenceServiceTest {

  @InjectMocks
  lateinit var conferenceService: ConferenceService

  @Mock
  lateinit var  conferenceRepository: ConferenceRepository

  @Mock
  lateinit var eventRepository: EventRepository

  val jsonString = File("./src/test/resources/conference.json").readText(Charsets.UTF_8)
  val conferenceMock = Gson().fromJson(jsonString, Conference::class.java)

  val jsonStringSec = File("./src/test/resources/event.json").readText(Charsets.UTF_8)
  val eventMock = Gson().fromJson(jsonStringSec, Event::class.java)

  @Test
  fun saveInvoiceWhenIsCorrect(){
    Mockito.`when`(eventRepository.findById(conferenceMock.eventId)).thenReturn(eventMock)
    Mockito.`when`(conferenceRepository.save(Mockito.any(Conference::class.java))).thenReturn(conferenceMock)
    val response = conferenceService.save(conferenceMock)
    Assertions.assertEquals(response.id, conferenceMock.id)
  }
}
