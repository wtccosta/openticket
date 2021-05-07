package br.gov.ms.corumba.opentickets.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] publicUrls = new String[] { "/api/**" };

		http.csrf().ignoringAntMatchers(publicUrls).and().authorizeRequests()

				.antMatchers("/webjars/**", "/css/**", "/image/**", "/js/**", "/api/**").permitAll()

				.antMatchers("/tickets/openform", "/tickets/create").permitAll()
				
				.anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/home", true)
				.failureUrl("/login-error").permitAll().and().logout().and().exceptionHandling()
				.accessDeniedPage("/forbidden-page");
	}
}
