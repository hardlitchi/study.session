package io.github.hardlitchi.rest.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import io.github.hardlitchi.rest.security.handler.SimpleAuthenticationSuccessHandler;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				// AUTHORIZE
				.authorizeRequests()
				.mvcMatchers("/signin", "/hello/**")
				.permitAll()
				.mvcMatchers("/**")
				.hasRole("USER")
				.anyRequest()
				.authenticated()
				.and()
				// EXCEPTION
				.exceptionHandling()
				.and()
				// LOGIN
				.formLogin()
				.loginProcessingUrl("/login").permitAll()
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(authenticationSuccessHandler())
				.and()
				// LOGOUT
				.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.and()
				// CSRF
				.csrf()
				.disable()
				//.ignoringAntMatchers("/login")
				//				.csrfTokenRepository(new CookieCsrfTokenRepository())
				//				.and()
				// SESSION
				.sessionManagement()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(false);
		// @formatter:on
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth,
			@Qualifier("simpleUserDetailsService") UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) throws Exception {
		auth.eraseCredentials(true)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new SimpleAuthenticationSuccessHandler();
	}
}
