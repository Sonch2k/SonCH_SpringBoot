package com.Monstarlab.SonCH.sercurity;


import com.Monstarlab.SonCH.entity.User;
import com.Monstarlab.SonCH.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {

    BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

    @Autowired
    UserRepository dao;

    public SercurityConfig() {

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(username -> {
            try {
                User user = dao.findByUsername(username);
                String password = user.getPassword();

                return org.springframework.security.core.userdetails.User.withUsername(username)
                        .password(password).roles("").build();
            } catch (Exception e) {
                throw new UsernameNotFoundException(username + "not found!");
            }
        });
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable().cors().disable();
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/css/**", "/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/admin/login/form")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/admin/login/sucess")
                .permitAll()
                .failureUrl("/admin/login/error");

    }

}
