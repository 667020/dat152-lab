package no.hvl.dat152.elib.client.servlets;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import no.hvl.dat152.elib.client.Constants;

/**
 * Servlet Filter implementation class ConstantsFilter
 */
@WebFilter(dispatcherTypes = {
		DispatcherType.REQUEST
}
			, urlPatterns = { "/constantsetter" })
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println(req.getRequestURI());
		
		if(req.getRequestURI().equals("/orderclient/index.jsp") || 
				req.getRequestURI().equals("/orderclient/") || req.getRequestURI().equals("/orderclient/callback")) {
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
