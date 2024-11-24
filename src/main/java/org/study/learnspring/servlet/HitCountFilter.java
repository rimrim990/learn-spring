package org.study.learnspring.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebFilter
public class HitCountFilter implements Filter {
    private final AtomicInteger integer = new AtomicInteger();
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        System.out.println("HitCounterFilter.init");
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
        System.out.println("HitCounterFilter.destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        StringWriter sw = new StringWriter();
        PrintWriter writer = new PrintWriter(sw);
        int count = integer.addAndGet(1);

        writer.println();
        writer.println("===============");
        writer.println("The number of hits is: " + count);
        writer.println("===============");
        writer.flush();

        filterConfig.getServletContext().log(sw.getBuffer().toString());
        servletRequest.setAttribute("hitCount", String.valueOf(count));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
