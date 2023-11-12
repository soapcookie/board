package com.example.board.jwt;

import com.example.board.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // 권한이 필요한 경로를 지정
        if (path.startsWith("/admin")) {
            if (userHasRole(UserRole.ADMIN)) {
                // 사용자가 관리자 권한을 가지고 있으면 계속 진행
                filterChain.doFilter(request, response);
            } else {
                // 권한이 없으면 403 Forbidden 에러 처리
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } else if (path.startsWith("/manager")) {
            if (userHasRole(UserRole.MANAGER)) {
                // 사용자가 매니저 권한을 가지고 있으면 계속 진행
                filterChain.doFilter(request, response);
            } else {
                // 권한이 없으면 403 Forbidden 에러 처리
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } else if (path.startsWith("/user")) {
            if (userHasRole(UserRole.USER)) {
                // 사용자가 일반 사용자 권한을 가지고 있으면 계속 진행
                filterChain.doFilter(request, response);
            } else {
                // 권한이 없으면 403 Forbidden 에러 처리
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            // 다른 경로는 그대로 진행
            filterChain.doFilter(request, response);
        }
    }

    private boolean userHasRole(UserRole role) {
        // 사용자의 권한을 확인하여 입력받은 role과 일치하는지 확인
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(role.getKey()));
    }
}
