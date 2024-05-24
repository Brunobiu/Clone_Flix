package Clone_Flix_security;

import javax.servlet.http.HttpSessionActivationListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import Clone_Flix_service.ImplementacaoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionActivationListener {

    private final ImplementacaoUserDetailsService implementacaoUserDetailsService;

    public WebConfigSecurity(ImplementacaoUserDetailsService implementacaoUserDetailsService) {
        this.implementacaoUserDetailsService = implementacaoUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .disable().authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                /* Redireciona ou da um retorno par o index quando desloga do sistema */
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/index")

                /* Mapeando parte de logount */
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                /* Filtra as requisiões para login de JWT */
                .and().addFilterAfter(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)

                .addFilterBefore(new JwtApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    /* Consultar o user no banco om sprin security */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(implementacaoUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // web.ignoring().antMatchers(HttpMethod.GET, "/salvarModel", "/deleteModel")
        // .antMatchers(HttpMethod.POST, "/salvarModel", "/deleteModel");
    }

}
