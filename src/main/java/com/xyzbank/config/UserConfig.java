package com.xyzbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserConfig {

    /*
    @Bean
    public JdbcUserDetailsManager createUserDetailsUsingJdbc(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    /*
    @Bean
    public InMemoryUserDetailsManager createUserDetails(){
        //return createUserDetailsApproach1();
        return createUserDetailsApproach2();
    }*/

    private InMemoryUserDetailsManager createUserDetailsApproach1() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    private InMemoryUserDetailsManager createUserDetailsApproach2() {
        UserDetails admin = User.withUsername("admin1")
                .password("12345")
                .build();

        UserDetails user = User.withUsername("user2")
                .password("12345")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder createPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
