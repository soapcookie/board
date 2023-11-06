package com.example.board.config;


import com.example.board.jwt.JwtAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        //헤더에 사용자 정보 포함 안함
        HttpSecurity.httpBasic().disable()
                //csrf 방지필요없음, 프엔이 해줌
                .csrf().disable()
                //분류자
                .and()
                //자원접근허용
                .cors()
                //html 페이지 임베딩 허용
                .headers().frameOptions().disable()
                .and()
                //로그인폼 사용안함
                .formLogin().disable()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                //로그인 회원가입 인증 필터 미적용
                .antMatchers(HttpMethod.GET,"/users/").permitAll()
        //권한 필요한 api들 여기에 넣기
        //나머지 요청에서는 제한없이 호출
                .anyRequest().permitAll()
                .and()
                //필터추가, BasicAuthenticationFilter.class 이전에 실행
                .addFilterBefore(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class)
                //예외처리
                .exceptionHandling()
                //인증되지않은 접근자에게 401에러보내기
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

        return httpSecurity.build();


    }
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


}
