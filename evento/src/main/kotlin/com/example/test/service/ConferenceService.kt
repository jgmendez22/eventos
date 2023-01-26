package com.example.test.service

import com.example.test.model.Conference
import com.example.test.model.Member
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
class ConferenceService {
  @Autowired
  lateinit var conferenceRepository: ConferenceRepository
  @Autowired
  lateinit var eventRepository: EventRepository


  fun save(conference: Conference): Conference {
    try {
      val response = conferenceRepository.save(conference)
      return response
    } catch (ex: Exception) {
      throw ResponseStatusException(
        HttpStatus.NOT_FOUND, ex.message, ex
      )
    }
  }


  fun list(pageable: Pageable, conference: Conference): Page<Conference> {
    val matcher = ExampleMatcher.matching()
      .withIgnoreNullValues()
      .withMatcher(("title"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
    return conferenceRepository.findAll(Example.of(conference, matcher), pageable)
  }


  fun listById(id:Long?): Conference? {
    return conferenceRepository.findById(id)
  }

  fun delete(id:Long?):Boolean?{
    conferenceRepository.findById(id)?:
    throw Exception()
    conferenceRepository.deleteById(id!!)
    return true
  }

  fun update(conference: Conference): Conference {
    try {
      conferenceRepository.findById(conference.id)
        ?: throw Exception("The id ${conference.id} in conference does not exist")
      return conferenceRepository.save(conference)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }

  fun updateName(conference: Conference): Conference {
    try {
      val response = conferenceRepository.findById(conference.id)
        ?: throw Exception("Id exists")
      response.apply {
        totalAttendees= conference.totalAttendees
      }

      return conferenceRepository.save(response)
    } catch (ex: Exception) {
      throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
    }
  }
  fun sumParticipants(conference:Conference) {
    val totalCalculated =  conferenceRepository.sumParticipants(conference.eventId)
    val response = eventRepository.findById(conference.eventId)
    response?.apply {
      totalAttendees = totalCalculated
    }
    eventRepository.save(response!!)
  }
}
