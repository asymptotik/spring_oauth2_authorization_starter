package com.asymptotik.authorization

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackages = ["com.asymptotik.authorization"])
open class AuthorizationWebAppInitializer : SpringBootServletInitializer() {
    companion object {
        val logger = LoggerFactory.getLogger(AuthorizationWebAppInitializer::class.java)!!
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        AuthorizationWebAppInitializer.logger.info("Starting Up!")
        return application.sources(AuthorizationWebAppInitializer::class.java)
    }

    fun main(args: Array<String>) {
        SpringApplication.run(AuthorizationWebAppInitializer::class.java, *args)
    }
}