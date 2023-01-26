package com.example.test.controller


import com.example.test.model.Member
import com.example.test.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/member")
class MemberController {
  @Autowired
  lateinit var memberService: MemberService
  @GetMapping("/{id}")

  fun listById (@PathVariable("id") id: Long): ResponseEntity<Member> {
    return ResponseEntity(memberService.listById(id), HttpStatus.OK)
  }

  @GetMapping
  fun list():List<Member>{
    return memberService.list()
  }

  @PostMapping
  fun save(@RequestBody member: Member):Member{
    return memberService.save(member)
  }

  @PutMapping
  fun update(@RequestBody member: Member) : ResponseEntity<Member> {
    return ResponseEntity ( memberService.update(member), HttpStatus.OK)
  }

  @PatchMapping
  fun updateName(@RequestBody member: Member) : ResponseEntity<Member> {
    return ResponseEntity ( memberService.updateName(member), HttpStatus.OK)
  }
  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable("id") id: Long):Boolean?{
    return memberService.delete(id)
  }

}
