package com.crudexampleproject.springbootcrudexample.config;

import com.crudexampleproject.springbootcrudexample.security.PasswordEncoderFactories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.cors();
        // http.csrf().disable();
        //http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();

        http
                .authorizeRequests(authorize -> {
                    authorize
                            //.antMatchers("/h2-console/**").permitAll() //do not use in production!
                            .antMatchers("/", "/login").permitAll();
                } )
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic()
                .and().csrf().disable();

        //h2 console config
        http.headers().frameOptions().sameOrigin();


    }

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password").roles("GUEST");
    }

     */


    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }






    // @Override
    //   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // auth.userDetailsService(this.jpaUserDetailsService).passwordEncoder(passwordEncoder());

//        auth.inMemoryAuthentication()
//                .withUser("spring")
//                .password("{bcrypt}$2a$10$7tYAvVL2/KwcQTcQywHIleKueg4ZK7y7d44hKyngjTwHCDlesxdla")
//                .roles("ADMIN")
//                .and()
//                .withUser("user")
//                .password("{sha256}1296cefceb47413d3fb91ac7586a4625c33937b4d3109f5a4dd96c79c46193a029db713b96006ded")
//                .roles("USER");
//
//        auth.inMemoryAuthentication().withUser("scott").password("{bcrypt15}$2a$15$baOmQtw8UqWZRDQhMFPFj.xhkkWveCTQHe4OBdr8yw8QshejiSbI6").roles("CUSTOMER");
    //  }
}

