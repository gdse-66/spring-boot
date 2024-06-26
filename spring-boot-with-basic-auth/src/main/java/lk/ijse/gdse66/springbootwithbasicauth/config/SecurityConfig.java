package lk.ijse.gdse66.springbootwithbasicauth.config;

import lk.ijse.gdse66.springbootwithbasicauth.dto.CustomerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // configure security filters in security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // disable CSRF protection
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()) // authenticate any HTTP request
                .httpBasic(Customizer.withDefaults()); // authenticate using basic authenticate (with default customization for it)
        return http.build();
    }

    //create a simple user details service that stores in memory.
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder() // encode password before saving in memory
                .username("Kasun")
                .password("abcd")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
