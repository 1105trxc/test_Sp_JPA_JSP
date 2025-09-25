package com.testd1.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        Boolean isAdmin = (session != null) ? (Boolean) session.getAttribute("isAdmin") : null;
        if (isAdmin != null && isAdmin) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/login?required=admin");
        return false;
    }
}