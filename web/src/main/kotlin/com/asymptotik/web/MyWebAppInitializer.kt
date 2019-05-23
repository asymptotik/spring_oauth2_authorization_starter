package com.asymptotik.web

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer


@SpringBootApplication(scanBasePackages = ["com.asymptotik.web"])
open class MyWebAppInitializer : SpringBootServletInitializer() {
    companion object {
        val logger = LoggerFactory.getLogger(MyWebAppInitializer::class.java)!!
    }

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        MyWebAppInitializer.logger.info("Starting Up!")
        return application.sources(MyWebAppInitializer::class.java)
    }

    fun main(args: Array<String>) {
        SpringApplication.run(MyWebAppInitializer::class.java, *args)
    }
}