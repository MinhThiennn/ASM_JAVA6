package com.poly;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poly.entity.Account;
import com.poly.service.AccountService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	AccountService accountService;
	
//	Mã hóa mật khẩuu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//Cho phép try xuất REST API từ bên ngoài (domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
//Quản lí dữ liệu người dùng
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				Account user = accountService.findById(username);
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream()
					.map(er -> er.getRole().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
					return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username+"not found!");
			}
		});
		
		
		
		
		
		
		
		
	
//		auth.userDetailsService(userService);
	
		
//		auth.inMemoryAuthentication()
//			.withUser("user1").password(pe.encode("123")).roles("GUEST")
//			.and()
//			.withUser("user2").password(pe.encode("123")).roles("USER","GUEST")
//			.and()
//			.withUser("user3").password(pe.encode("123")).roles("USER","ADMIN","GUEST");
	}
	
//Phân quyền sử dụng và hình thưc đăng nhập
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//CSRF, CORS
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/order/**").authenticated()
			.antMatchers("/admin/**").hasAnyRole("STAFF","DIRE")
			.antMatchers("/rest/authoritise").hasRole("DIRE")
			.anyRequest().permitAll();
		
		http.formLogin()
			.loginPage("/security/login/form")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/security/login/success",false)
			.failureUrl("/security/login/error");
		
		http.rememberMe()
		.tokenValiditySeconds(86400);//[remember]
		
		http.exceptionHandling()
		.accessDeniedPage("/security/unauthoried");
		
		//Đăng xuất
		http.logout()
			.logoutUrl("/security/logoff")
			.logoutSuccessUrl("/security/logoff/success");
		
		
		//Phân quyền sử dụng
//		http.authorizeRequests()
//			.antMatchers("/home/index","/auth/login/**").permitAll()
//			.anyRequest().authenticated();
		
//		http.authorizeRequests()
//			.antMatchers("/home/admins").hasRole("ADMIN")
//			.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
//			.antMatchers("/home/authenticated").authenticated()
//			.anyRequest().permitAll();
//		http.authorizeRequests()
//			.anyRequest().permitAll(); //anonymous
		
		
		//Điều khiển lỗi tru cập không đúng vai trò
//		http.exceptionHandling()
//		.accessDeniedPage("/auth/success/denied");
		
		//Giao diện đagnw nhập
//		http.formLogin()
//			.loginPage("/auth/login/form")
//			.loginProcessingUrl("/auth/login")//[Login]
//			.defaultSuccessUrl("/auth/login/success",false)
//			.failureUrl("/auth/login/error")
//			.usernameParameter("username")//[Username]
//			.passwordParameter("password");//[Password]
//		http.rememberMe()
//			.rememberMeParameter("remember");//[remember]
//		
		//Đăng xuất
//		http.logout()
//			.logoutUrl("/auth/logoff")
//			.logoutSuccessUrl("/auth/logoff/success");
		
		//OAUTH2 - Đăng nhập xã hội
//		http.oauth2Login()
//			.loginPage("/auth/login/form")
//			.defaultSuccessUrl("/oauth2/login/success", true)
//			.failureUrl("/auth/login/error")
//			.authorizationEndpoint()
//				.baseUri("/oauth2/authorization");
	}

}

