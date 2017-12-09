package com.mal.tesseract.security;

import com.mal.tesseract.model.Role;
import com.mal.tesseract.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
    private static Logger logger = Logger.getLogger(WebSecurityConfiguration.class);

    private final AccountRepository accountRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return (username) -> accountRepository
                .findByUsername(username)
                .map(a -> {
                    User user  = new User(a.getUsername(), a.getPassword(), a.getEnabled(), a.getAccountNotExpired(),
                            a.getCredentialsNonExpired(), a.getAccountNonLocked(),
                            AuthorityUtils.commaSeparatedStringToAuthorityList(
                                    new ArrayList<>(a.getRoles()).stream().map(Role::getName)
                                            .collect(Collectors.joining(","))));
                    logger.info(user.toString());
                    return user;
                })
                .orElseThrow(
                        () -> new UsernameNotFoundException("could not find the user '"
                                + username + "'"));
    }
}