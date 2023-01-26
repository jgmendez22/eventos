package com.example.test.model

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="register")
class Register {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id:Long? = null
  @NotBlank
  var code:String? = null
  @Column(name="registered_at")
  var registeredAt:String? = null
  @NotNull
  var assisted:Boolean? = null
  @Column(name = "conference_id")
  var conferenceId:Long?=null
  @Column(name = "member_id")
  var memberId:Long?=null



}
