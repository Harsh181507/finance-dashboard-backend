package com.pm.zorvynfinancedashboardbackend.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class RateLimitFilter implements Filter {

    private final Map<String, Integer> requestCounts = new HashMap<>();
    private final Map<String, Long> requestTimestamps = new HashMap<>();

    private final int MAX_REQUESTS = 50;
    private final long TIME_WINDOW = 60 * 1000; // 1 minute

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String ip = req.getRemoteAddr();
        long currentTime = System.currentTimeMillis();

        requestTimestamps.putIfAbsent(ip, currentTime);

        if (currentTime - requestTimestamps.get(ip) > TIME_WINDOW) {
            requestCounts.put(ip, 0);
            requestTimestamps.put(ip, currentTime);
        }

        requestCounts.put(ip, requestCounts.getOrDefault(ip, 0) + 1);

        if (requestCounts.get(ip) > MAX_REQUESTS) {
            res.setStatus(429);
            res.getWriter().write("Too many requests. Try again later.");
            return;
        }

        chain.doFilter(request, response);
    }
}