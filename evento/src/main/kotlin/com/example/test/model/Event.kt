package com.example.test.model


import java.util.Date
import javax.persistence.*

@Entity
@Table(name="event")
class Event {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id:Long? = null
  var description:String? = null
  @Column(name = "start_date")
  var startDate:Date? = null
  @Column(name = "end_date")
  var endDate:Date? = null
  @Column(name = "total_attendees")
  var totalAttendees: Long? = null
  var city:String? = null

}

