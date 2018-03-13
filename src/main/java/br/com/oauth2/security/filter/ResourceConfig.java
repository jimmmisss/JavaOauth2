package br.com.oauth2.security.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) {
        resource.resourceId("restservice");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
            .cors()
            .and()
            .csrf().disable()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .and().authorizeRequests()
            .antMatchers(HttpMethod.GET, "/*/public/**").permitAll()
            .antMatchers(HttpMethod.GET, "/*/protected/**").hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.GET, "/*/admin/**").hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/*/admin/**").hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/*/admin/**").hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/*/admin/**").hasAnyRole("ADMIN")
            .anyRequest().denyAll();

    }

}