package com.example.test.service

import com.example.test.model.Conference
import com.example.test.model.Event
import com.example.test.repository.ConferenceRepository
import com.example.test.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EventService {
  @Autowired
  lateinit var eventRepository: EventRepository


  fun list(pageable: Pageable, event: Event): Page<Event> {
    val matcher = ExampleMatcher.matching()
      .withIgnoreNullValues()
      .withMatcher(("place"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
    return eventRepository.findAll(Example.of(event, matcher), pageable)
  }

  fun listById(id:Long?):Event?{
    return eventRepository.findById(id)
  }
  fun delete(id:Long?):Boolean?{
    eventRepository.findById(id)?:
    throw Exception()
    eventRepository.deleteById(id!!)
    return true
  }
  fun save(event: Event): Event {
    try {
      event.description?.takeIf { it.trim().isNotEmpty() }
        ?: throw Exception("description cannot be empty")


//client.fullname?.takeIf { it.stock > 0 }
      //              ?: throw Exception("fullname no debe ser vacio")

      return eventRepository.save(event)
    }
    catch(ex:Exception){
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }

  }

  fun update(event: Event): Event {
    try {
      eventRepository.findById(event.id)
        ?: throw Exception("The id ${event.id} in event does not exist")
      return eventRepository.save(event)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }



}
