package com.example.capstone.security;


import com.example.capstone.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.HiddenHttpMethodFilter;  //filter responsible for converting PST requests with _mthod parameters into appropriate HTTP methods like delete, put


@EnableWebSecurity
@Configuration
public class SecurityConfig  {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("===========>IN filterChain() ");
        http.authorizeHttpRequests()
                .requestMatchers(
                        "/",                    //Home page
                        "/index**",             //index page
                        "/registration**",      //registration page
                        "/booking**",           //bookings page
                        "/destinations",        //destinations page
                        "/css/**",         //all ss files in this directory
                        "/img/**",         //all images in this directory
                        "/js/**",           //javascript files
                        "/templates/**",  //all html and jss files in this directory
                        "/webjars/**"           //webjar files for js/css libraries
                ).permitAll()
                .requestMatchers("/booking/**").authenticated()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/booking", true) // Redirect to /booking/new after successful login
                .permitAll().and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll()
                .and()
                .csrf().ignoringRequestMatchers("/booking**"); // Optional: Enable CSRF for all but specific paths
        return http.build();
    }
    //You may declare @Bean methods as static, allowing for them to be called without
    //creating their containing configuration class as an instance
    // this eliminates having to do this in app prop file:
    // spring.main.allow-circular-references: true
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
   }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


}
