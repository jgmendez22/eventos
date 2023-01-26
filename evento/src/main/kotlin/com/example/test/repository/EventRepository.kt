package com.example.test.repository


import com.example.test.model.Event
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository:JpaRepository<Event, Long> {
  fun findById(id:Long?): Event?


}
