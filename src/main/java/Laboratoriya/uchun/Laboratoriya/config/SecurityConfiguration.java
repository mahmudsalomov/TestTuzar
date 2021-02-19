package Laboratoriya.uchun.Laboratoriya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("customUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user")).roles("USER");

        auth
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//                .and()
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");

    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/test/*").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/getusername").permitAll()
                .antMatchers("/dist/*").permitAll()
                .antMatchers("/all").permitAll()
                .antMatchers("/all/*").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/success").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/user/*").hasAuthority("USER")
                .antMatchers("/user/**").hasAuthority("USER")
//                .antMatchers("/user").hasRole("USER")
//                .antMatchers("/user/*").hasRole("USER")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/admin/*").hasAuthority("ADMIN")
//                .antMatchers("/user/*").hasAuthority("ADMIN")
////                .antMatchers("/admin/api/*").hasRole("ADMIN")
////                .antMatchers("/admin/simple-test").hasRole("ADMIN")
////                .antMatchers("/admin/simple-home").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll();

    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    String getCurrentUsername(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
}
