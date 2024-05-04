package com.tutorial.vaadin.full;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.vaadin.flow.spring.security.VaadinWebSecurity;

import com.tutorial.vaadin.full.ui.LoginView;

@SpringBootApplication
public class FullApplication extends VaadinWebSecurity {

	public static void main(String[] args) {
		SpringApplication.run(FullApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		setLoginView(http, LoginView.class);
	}

	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new InMemoryUserDetailsManager(
			User.withUsername("Admin")
				.password("{noop}admin")
				.roles("ADMIN").build(),

			User.withUsername("User")
				.password("{noop}user")
				.roles("USER").build()
		);
	}

}
