package se452.group4.project.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import se452.group4.project.security.user.UserDetailsServiceImpl;

/**
 * Startup Configuration Class for FlixNet Security.
 */
@Configuration
@EnableGlobalMethodSecurity(
    securedEnabled = true,
	jsr250Enabled = true,
    prePostEnabled = true)
public class WebSecurityConfig {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    /**
     * Sets up the basic Security Filter Chain for all Http Requests that comet through the application.
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var permittedRoutes = new String [] {
            // "/h2-console/**",
            "/api/auth/**",
            "/api/movie/**",
            "/api/showtime/**",
            "/"
            // "/home", 
            // "/swagger-ui/**",
            // "/v3/api-docs/**"
        };

        http.cors().and().csrf().disable()
            .authorizeRequests((requests) -> requests
                .antMatchers(permittedRoutes).permitAll()
                .anyRequest().authenticated())
                // .antMatcher("/api/*").exceptionHandling().authenticationEntryPoint(new ApiUnauthorizedEntryPoint())
                // .and()
                .formLogin()
                .and()
                .logout();

        // h2-console DB fails with frame deny issues without this.
        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    /**
     * Startup setup for DaoAuthenticationProvider to setup custom auth services.
     * @return
     */
    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        // Sets the in-memory users for Development purposes of 
        provider.setUserDetailsService(userDetailsService);

        // Sets the password encoder that the UserDetailsService uses to the BCryptPasswordEncoder.
        provider.setPasswordEncoder(getPasswordEncoder());

        return provider;
    }

    /**
     * returns a BCryptPasswordEncoder.
     * @return BCryptPasswordEncoder
     */
	@Bean
    BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }    

    /**
     * Builds InMemory Users for us to use to authenticate with Spring Security Web App. DEVELOPMENT ONLY.
     */
    @Bean
    UserDetailsService getUserDetailsService() {
        UserDetails user = 
            User.builder()
                .username("customer")
                .password(getPasswordEncoder().encode("password"))
                .roles("CUSTOMER")
                .build();

        UserDetails admin = 
            User.builder()
                .username("admin")
                .password(getPasswordEncoder().encode("password"))
                .roles("ADMIN", "CUSTOMER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
