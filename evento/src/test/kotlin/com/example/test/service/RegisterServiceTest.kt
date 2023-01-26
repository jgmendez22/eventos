package com.example.test.service

import com.example.test.model.Register
import com.example.test.repository.RegisterRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class RegisterServiceTest {

  @InjectMocks
  lateinit var registerService: RegisterService

  @Mock
  lateinit var  registerRepository: RegisterRepository

  val jsonString = File("./src/test/resources/register.json").readText(Charsets.UTF_8)
  val registerMock = Gson().fromJson(jsonString, Register::class.java)

  @Test
  fun saveRegisterCorrect(){
    Mockito.`when`(registerRepository.save(Mockito.any(Register::class.java))).thenReturn(registerMock)
    val response = registerService.save(registerMock)
    Assertions.assertEquals(response?.id, registerMock.id)
  }

  @Test
  fun saveRegisterWhenCodeIsBlank(){

    Assertions.assertThrows(Exception::class.java) {
      registerMock.apply { code=" "}
      Mockito.`when`(registerRepository.save(Mockito.any(Register::class.java))).thenReturn(registerMock)
      registerService.save(registerMock)
    }

  }
}
