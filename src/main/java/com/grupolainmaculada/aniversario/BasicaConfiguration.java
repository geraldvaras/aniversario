package com.grupolainmaculada.aniversario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class BasicaConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("kathieen")
                .password(passwordEncoder.encode("k2022"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("veronica")
                .password(passwordEncoder.encode("v2022"))
                .roles("USER")
                .build();

        UserDetails aracely = User.withUsername("aracely")
                .password(passwordEncoder.encode("a2022"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin, aracely);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }


}
