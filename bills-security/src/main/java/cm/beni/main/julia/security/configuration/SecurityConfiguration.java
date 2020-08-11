package cm.beni.main.julia.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import cm.beni.main.julia.security.service.JuliaUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private AuthenticationProvider authenticationProvider;

	@Autowired
	private AuthenticateEntryPoint entryPoint;

	@Autowired
	private JuliaUserDetailsService userDetailsService;

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("beni").password("{noop}beni@123").roles("USER");
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

//	@Autowired
//	public void configureAuthManager(AuthenticationManagerBuilder authenticationManagerBuilder) {
//		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
//	}

	/**
	 * @param passwordEncoder
	 * @param userDetailsService
	 * @return
	 */
//	@Bean
//	public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
//			JuliaUserDetailsService userDetailsService) {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//		return daoAuthenticationProvider;
//	}

	/**
	 *
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/webjars/**").permitAll().anyRequest().authenticated()
//				.and().formLogin().loginPage("").permitAll().and().logout().deleteCookies("remember-me").permitAll()
//				.and().rememberMe().tokenValiditySeconds(300);
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic()
				.authenticationEntryPoint(entryPoint);
	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
}
