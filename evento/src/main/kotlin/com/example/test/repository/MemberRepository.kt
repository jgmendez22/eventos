package com.example.test.repository


import com.example.test.model.Member
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

@Repository
interface MemberRepository:JpaRepository<Member, Long> {
  fun findById(id:Long?):Member?


}
