package com.example.test.repository



import com.example.test.model.Register
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.persistence.Id

@Repository
interface RegisterRepository:JpaRepository<Register, Long> {
  fun findById(id:Long?): Register?

  @Query(nativeQuery = true)
  fun allConferences(@Param("mid") mid: Long?):Any?

  @Query(nativeQuery = true)
  fun sumAssisted(@Param("conferenceId")conferenceId: Long?):Long?
}
