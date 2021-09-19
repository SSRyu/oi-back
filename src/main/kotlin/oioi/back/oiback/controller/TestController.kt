package oioi.back.oiback.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun index(): String = "Hello Spring boot TestController!"
}
