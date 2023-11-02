package in.spring.ath.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurity{


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsServiceImpl detailsServiceImpl() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		provider.setUserDetailsService(detailsServiceImpl());
		
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		
		security.authenticationProvider(authenticationProvider());
		
		security.authorizeHttpRequests().requestMatchers("/**").permitAll()
		.and().formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/home").and().csrf().disable();
		
		return security.build();
	}
}
