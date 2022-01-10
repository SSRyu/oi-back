package oioi.back.oiback.controller

import io.swagger.annotations.Api
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@Api(description = "apiコントローラ")
public class TestController {
    val helloMessage: String = "Hello Spring boot TestController!"

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun index(): String = helloMessage

    @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses(
        *[ApiResponse(responseCode = "200", description = "OK !!"), ApiResponse(
            responseCode = "400",
            description = "BAD REQUEST !!"
        ), ApiResponse(responseCode = "404", description = "NOT FOUND !!"), ApiResponse(
            responseCode = "500",
            description = "INTERNAL SERVER ERROR !!"
        )]
    )
    @GetMapping("/hello")
    fun swaggerTest(
        @Parameter(
            description = "이름",
            required = true,
            example = "Default Name"
        ) @RequestParam name: String
    ): ResponseEntity<String?>? {
        return ResponseEntity.ok("hello $name")
    }
}
