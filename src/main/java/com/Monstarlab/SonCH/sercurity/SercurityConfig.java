package com.Monstarlab.SonCH.sercurity;


import com.Monstarlab.SonCH.entity.User;
import com.Monstarlab.SonCH.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SercurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    private PasswordEncoder pe;
    private AuthenTokenFilter authenTokenFilter;
    private EntryPoint entryPoint;
    @Autowired
    UserRepository dao;
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(pe);
//        auth.userDetailsService(username -> {
//            try {
//                User user = dao.findByUsername(username);
//                String password = user.getPassword();
//
//                return org.springframework.security.core.userdetails.User.withUsername(username)
//                        .password(password).roles("").build();
//            } catch (Exception e) {
//                throw new UsernameNotFoundException(username + "not found!");
//            }
//        });
    }
    @Override
    protected void configure( HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth","/register","/admin/login/error","/admin/login/sucess").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/admin/login/form")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/admin/login/sucess")
                .permitAll()
                .failureUrl("/admin/login/error");
        http.addFilterBefore(authenTokenFilter,UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
