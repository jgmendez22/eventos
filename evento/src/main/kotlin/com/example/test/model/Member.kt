package com.example.test.model

import javax.persistence.*
import javax.validation.constraints.Email

@Entity
@Table(name="member")
class Member {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id:Long? = null
  var fullname:String? = null
  @Email
  var email:String? = null
  var age:Long? = null

}
