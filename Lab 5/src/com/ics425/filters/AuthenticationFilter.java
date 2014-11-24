package com.ics425.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ics425.model.Address;
import com.ics425.model.Person;
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, 
		urlPatterns = { 
				"/address.jsp", 
				"/confirm.jsp"
		})
public class AuthenticationFilter implements Filter {
	FilterConfig fc;
    public AuthenticationFilter() { }
    public void destroy() {    }
    public void doFilter(ServletRequest request, ServletResponse response, 
      FilterChain chain) 
      throws IOException, ServletException {
        String message = "Unauthenticated user must start at the first page in the flow";
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        boolean authenticated = false;
        String forwardPage = "/name.jsp";
        synchronized(session) {
            if (req.getRequestURI().contains("confirm.jsp")) {
                if (null != session.getAttribute("person")) {
                    message = "You must enter person information.";
                    authenticated = ((Person)session.getAttribute("person")).validate();
                }                        
                if (authenticated && null != session.getAttribute("address")) {
                    message = "You must enter address information.";
                    forwardPage = "/address.jsp";
                    authenticated = 
                      ((Address)session.getAttribute("address")).validate();
                }
            } else if (req.getRequestURI().contains("address.jsp")) {
                if (null != session.getAttribute("person")) {
                    message = "You must enter person information.";
                    authenticated = ((Person)session.getAttribute("person")).validate();
                }                        
            }
            if (!authenticated) {
                request.setAttribute("message", message);
                fc.getServletContext().getRequestDispatcher(forwardPage).
                  forward(request, response);                                    
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        fc = fConfig;
    }
}
