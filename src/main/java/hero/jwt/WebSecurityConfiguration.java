package hero.jwt;

import hero.service.sign_login_service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    private final MyUserDetailsService myUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public WebSecurityConfiguration(MyUserDetailsService myUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.myUserDetailsService = myUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers(
                        "/api/admin/signup", "/api/admin/login",
                                "/api/admin/admins","/api/admin/admins/{id}",
                                "/api/user/signup","/api/user/login","/api/admin/users",
                                "/api/admin/users/{id}","/api/admin/products","/api/admin/products/subcategory/{subcategoryId}","/api/admin/products/{id}","/api/admin/products/products/{subcategoryId}"
                                ,"/api/admin/categories","/api/admin/categories/{id}","/api/admin/categories/{categories}/subcategories","/api/admin/products/byCategory/{categoryId}",
                                "/api/admin/categories/{categoryId}/products","/api/admin/orders/{id}","/api/admin/orders"
                                ,"/api/analytics-fields","/api/analytics-fields/{id}","/api/admin/subcategories/category/{categoryId}","/api/admin/subcategories"
                                ,"/api/admin/subcategories/{Id}")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                ).userDetailsService(myUserDetailsService)
                .sessionManagement(session->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
