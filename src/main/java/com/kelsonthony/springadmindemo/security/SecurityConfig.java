package com.kelsonthony.springadmindemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler
		= new SavedRequestAwareAuthenticationSuccessHandler();
		
		savedRequestAwareAuthenticationSuccessHandler.setTargetUrlParameter("redirectTo");
		savedRequestAwareAuthenticationSuccessHandler.setDefaultTargetUrl("/");
		
		http.authorizeRequests()
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/login")
			.successHandler(savedRequestAwareAuthenticationSuccessHandler).and()
			.logout().logoutUrl("/logout").and()
			.httpBasic().and()
			.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.ignoringAntMatchers(
					"/instances",
					"actuator/**");
	}
}
