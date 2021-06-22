package oioi.back.oiback.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class TestContoller {
  @RequestMapping(value = ["/"], method = [RequestMethod.GET])
  fun Index() : String = "Hello Spring boot TestContoller!"
}