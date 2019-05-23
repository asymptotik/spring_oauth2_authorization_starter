package com.asymptotik.web

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    /*
    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {

    }

     */

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/index**", "/login**", "/webjars/**", "/error**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and().logout().logoutSuccessUrl("/").permitAll()
            .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
    }
}