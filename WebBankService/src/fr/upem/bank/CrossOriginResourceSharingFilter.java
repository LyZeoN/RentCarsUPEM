package fr.upem.bank;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(urlPatterns = { "/" })
public class CrossOriginResourceSharingFilter implements Filter {

    public CrossOriginResourceSharingFilter() { }

    @Override
    public void init(FilterConfig fConfig) throws ServletException { }

    @Override
    public void destroy() { }

    @Override
    public void doFilter(
        ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {

        ((HttpServletResponse)response).addHeader(
            "Access-Control-Allow-Origin", "*"
        );
                ((HttpServletResponse)response).addHeader(
            "Access-Control-Allow-Headers", "Content-Type, Authorization, Accept"
        );
                ((HttpServletResponse)response).addHeader(
                        "Access-Control-Allow-Methods", "GET, POST, OPTIONS"
                );

        chain.doFilter(request, response);
    }

}