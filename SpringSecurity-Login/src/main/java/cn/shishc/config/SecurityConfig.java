package cn.shishc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @PackageName:cn.shishc.config
 * @Date:2020/12/30, 16:09
 * @Auther:ShiShc
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/root/**").hasRole("root")
                    .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder
                .inMemoryAuthentication()
                .withUser("root")
                    .roles("root","user")
                    .password("{noop}root")
                    .and()
                .withUser("user")
                    .roles("user")
                    .password("{noop}user");
    }
}
