package com.softexpansion.searchlibrary.config;

import com.softexpansion.searchlibrary.enums.Role;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import java.io.IOException;

@Component
@AllArgsConstructor
public class UserRoleFilterChain implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean isLibrarian = ((RequestFacade) servletRequest).getHeader("role").equals(Role.LIBRARIAN.getValue());
        if (!isLibrarian && !((RequestFacade) servletRequest).getServletPath().contains("books")) {
            servletResponse.getOutputStream().print("forbidden");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
