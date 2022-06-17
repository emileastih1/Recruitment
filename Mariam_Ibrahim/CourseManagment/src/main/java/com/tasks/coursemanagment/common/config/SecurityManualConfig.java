package com.tasks.coursemanagment.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityManualConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        //firstStudent/firstStudentPass
        //secondStudent/secondStudentPass
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("firstStudentPass")).roles("admin")
                .and()
                .withUser("firstStudent").password(passwordEncoder().encode("firstStudentPass")).roles("USER")
                .and()
                .withUser("secondStudent").password(passwordEncoder().encode("secondStudentPass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");

    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {

             http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated().and()
                .httpBasic();//normail username /password in header
//                 .and().oauth2ResourceServer().jwt(); //using jwt authurization
    }
}
