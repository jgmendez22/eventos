package com.example.test.controller

import com.example.test.model.Event
import com.example.test.service.EventService
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/event")
class EventController {
  @Autowired
  lateinit var eventService: EventService

  @GetMapping
  fun list(pageable: Pageable, event:Event):ResponseEntity<*>{
    val response = eventService.list(pageable, event)
    return ResponseEntity(response, HttpStatus.ACCEPTED)
  }

  @GetMapping("/{id}")
  fun listById(@PathVariable("id") id:Long):ResponseEntity<Event>{
    return ResponseEntity(eventService.listById(id), HttpStatus.ACCEPTED)
  }



  @PostMapping
  fun save(@RequestBody @Valid event: Event): ResponseEntity<Event>?{
    return ResponseEntity(eventService.save(event), HttpStatus.ACCEPTED)

  }

  @PutMapping
  fun update(@RequestBody event:Event): ResponseEntity<Event> {
    return ResponseEntity(eventService.update(event), HttpStatus.ACCEPTED)
  }
  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable("id") id:Long):Boolean?{
    return eventService.delete(id)
  }



}
