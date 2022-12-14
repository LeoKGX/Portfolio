
package com.miapp.portfolio;

import com.miapp.portfolio.jwt.JwtTokenFilter;
import com.miapp.portfolio.repository.IUserRepo;
import java.time.Duration;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private IUserRepo userRepo;
    
    @Autowired private JwtTokenFilter jwtfilter;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(
            username -> userRepo.findByEmail(username)
                .orElseThrow(
                    () -> new UsernameNotFoundException("User " + username + " not found.")));
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }  
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(withDefaults());
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    
        http.exceptionHandling().authenticationEntryPoint(
                ((request, response, ex) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        ex.getMessage());
                })
        );
    
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/aboutme").permitAll()
            .antMatchers("/certificados").permitAll()
            .antMatchers("/educacion").permitAll()
            .antMatchers("/skill").permitAll()
            .antMatchers("/persona").permitAll()
            .antMatchers("/proyectos").permitAll()
            .antMatchers("/xp").permitAll()
            .anyRequest().authenticated();
        
        http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration cc = new CorsConfiguration();
                cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers","Authorization"));
                cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));                
                cc.setAllowedOrigins(Arrays.asList("/*"));
                cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT","PATCH"));
                cc.addAllowedOrigin("https://intidn-f38c0.web.app");
                cc.addAllowedOrigin("https://intidn-f38c0.web.app/login");
                cc.addAllowedOrigin("https://intidn-f38c0.web.app/portfolio");
                cc.setMaxAge(Duration.ZERO);
                cc.setAllowCredentials(Boolean.TRUE);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", cc);
            return source;
    }

}
