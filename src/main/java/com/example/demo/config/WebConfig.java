package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private final String findUserByEmail = "select email as principal, password as credentails, true from usuario where email=?";

    private final String authoritiesByEmailQuery = "select email as principal, role_name as role from USUARIO where email=?";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(findUserByEmail)
                .authoritiesByUsernameQuery(authoritiesByEmailQuery)
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");

    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/usuario/listar")
                .hasRole("ADMIN")
                .and()
                .formLogin()
                .and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
                .and().headers().frameOptions().sameOrigin();//allow use of frame to same origin urls
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/usuario/cadastrar","dale");
    }

}
