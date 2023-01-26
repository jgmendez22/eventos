package com.example.test.controller


import com.example.test.model.Conference
import com.example.test.model.Register
import com.example.test.service.RegisterService
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.persistence.Column

@RestController
@RequestMapping("/register")
class RegisterController {
  @Autowired
  lateinit var registerService: RegisterService

  @GetMapping
  fun list(pageable: Pageable, register: Register):ResponseEntity<*>{
    val response = registerService.list(pageable, register)
    return ResponseEntity(response, HttpStatus.ACCEPTED)
  }

  @GetMapping("/{id}")
  fun listById(@PathVariable("id") id:Long):ResponseEntity<Register>?{
    return ResponseEntity(registerService.listById(id), HttpStatus.ACCEPTED)
  }
  @GetMapping("/conference/{mid}")
  fun listConferences(@PathVariable("mid") id: Long):ResponseEntity<*>{
    val response = registerService.listConferences(id)
    return ResponseEntity(response, HttpStatus.ACCEPTED)
  }


  @PostMapping
  fun save(@RequestBody @Valid register: Register): ResponseEntity<Register>?{
    return ResponseEntity(registerService.save(register), HttpStatus.ACCEPTED)

  }

  @PutMapping
  fun update(@RequestBody register:Register): ResponseEntity<Register> {
    return ResponseEntity(registerService.update(register), HttpStatus.ACCEPTED)
  }

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable("id") id:Long):Boolean?{
    return registerService.delete(id)
  }

  @PatchMapping
  fun updateAssisted(@RequestBody register: Register):ResponseEntity<Register>{
    return ResponseEntity(registerService.updateAssisted(register), HttpStatus.ACCEPTED)
  }

}
