package com.abc.filter;

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

import com.abc.model.*;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = {
		"/address.jsp", "/contactConfirm.jsp", "/contactName.jsp",
		"/contactViewAll.jsp", "/credentials.jsp", "/email.jsp", "/phone.jsp",
		"/user.jsp", "/viewAllUsers.jsp" })
public class AuthenticationFilter implements Filter {
	FilterConfig fc;

	public AuthenticationFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String message = "Unauthenticated user must start at the first page in the flow";
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		boolean authenticated = false;
		String forwardPage = "/index.jsp";
		synchronized (session) {
			if (req.getRequestURI().contains("contactName.jsp")) {
				if (null != session.getAttribute("contactName")) {
					message = "You must enter Contact information.";
					authenticated = ((ContactName) session
							.getAttribute("contactName")).validate();
				} else if (req.getRequestURI().contains("address.jsp")) {
					if (authenticated
							&& null != session.getAttribute("address")) {
						message = "You must enter address information.";
						forwardPage = "/address.jsp";
						authenticated = ((Address) session
								.getAttribute("address")).validate();
					} else if (req.getRequestURI().contains("phone.jsp")) {
						if (authenticated
								&& null != session.getAttribute("phone")) {
							message = "You must enter Phone Number.";
							forwardPage = "/phone.jsp";
							authenticated = ((Phone) session
									.getAttribute("phone")).validate();
						} else if (req.getRequestURI().contains("email.jsp")) {
							if (null != session.getAttribute("email")) {
								message = "You must enter Email Address.";
								forwardPage = "/email.jsp";
								authenticated = ((Email) session
										.getAttribute("email")).validate();
							} else if (req.getRequestURI().contains(
									"credentials.jsp")) {
								if (null != session.getAttribute("credentials")) {
									message = "You must enter person information.";
									forwardPage = "/credentials.jsp";
									authenticated = ((Credentials) session
											.getAttribute("credentials"))
											.validate();
								}
							}
							if (!authenticated) {
								request.setAttribute("message", message);
								fc.getServletContext()
										.getRequestDispatcher(forwardPage)
										.forward(request, response);
							}
						}
						chain.doFilter(request, response);
					}
				}
			}
		}
	}

    public void init(FilterConfig fConfig) throws ServletException {
        fc = fConfig;
    }
}
