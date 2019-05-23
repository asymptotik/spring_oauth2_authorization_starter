package com.asymptotik.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
open class UserController {

    @RequestMapping("/user")
    fun user(principal: Principal): Principal {
        return principal
    }
}