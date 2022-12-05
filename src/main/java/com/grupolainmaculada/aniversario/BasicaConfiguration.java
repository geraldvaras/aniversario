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
        UserDetails user = User.withUsername("KATHIEEN")
                .password(passwordEncoder.encode("K2022"))
                .roles("USER")
                .build();

        UserDetails veronica = User.withUsername("VERONICA")
                .password(passwordEncoder.encode("V2022"))
                .roles("USER")
                .build();

        UserDetails aracely = User.withUsername("ARACELI")
                .password(passwordEncoder.encode("A2022"))
                .roles("USER")
                .build();

        UserDetails daniela = User.withUsername("DANIELA")
                .password(passwordEncoder.encode("D2022"))
                .roles("USER")
                .build();

        UserDetails mayri = User.withUsername("MAYRI")
                .password(passwordEncoder.encode("M2022"))
                .roles("USER")
                .build();

        UserDetails irene = User.withUsername("IRENE")
                .password(passwordEncoder.encode("I2022"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, veronica, aracely, daniela, mayri, irene);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }


}
