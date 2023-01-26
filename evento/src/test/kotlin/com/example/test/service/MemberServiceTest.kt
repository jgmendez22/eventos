package com.example.test.service

import com.example.test.model.Member
import com.example.test.repository.MemberRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class MemberServiceTest {

  @InjectMocks
  lateinit var memberService: MemberService

  @Mock
  lateinit var  memberRepository: MemberRepository

  var memberMock = Member().apply{
    id=1
    fullname="Jonnathan Mendez"
    email="jonnasmen34@gmail.com"
    age=20
  }

  @Test
  fun saveMemberCorrect(){
    Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
    val response = memberService.save(memberMock)
    Assertions.assertEquals(response?.id, memberMock.id)
  }

  @Test
  fun saveMemberWhenFullnameIsBlank(){

    Assertions.assertThrows(Exception::class.java) {
      memberMock.apply { fullname=" "}
      Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
      memberService.save(memberMock)
    }

  }
}
