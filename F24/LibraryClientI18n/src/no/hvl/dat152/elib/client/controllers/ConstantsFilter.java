package no.hvl.dat152.elib.client.controllers;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat152.elib.client.Constants;

/**
 * Servlet Filter implementation class ConstantsFilter
 */
public class ConstantsFilter extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public ConstantsFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println(req.getRequestURI());
		
		if(req.getRequestURI().equals("/orderclient/order.jsp") || 
				req.getRequestURI().equals("/orderclient/")) {
			request.setAttribute("isbn", request.getParameter("isbn"));
			request.setAttribute("client_id", Constants.CLIENT_ID);
			request.setAttribute("state", Constants.STATE);
			request.setAttribute("redirect_url", Constants.SP_CALLBACK_ADDRESS);
		} 
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
