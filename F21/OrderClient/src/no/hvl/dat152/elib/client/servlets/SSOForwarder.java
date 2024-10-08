package no.hvl.dat152.elib.client.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import no.hvl.dat152.elib.client.Constants;
import no.hvl.dat152.elib.client.HttpClient;

/**
 * Servlet implementation class SSOForwarder
 */
@WebServlet("/sso")
public class SSOForwarder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSOForwarder() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		String expiry = request.getParameter("expiry");
		
//		String userid = request.getParameter("userid");
//
//		Constants.USER_ENDPOINT += userid + "/orders"; 
		Constants.JSON_DATA = "{\"isbn\":\""+isbn+"\",\"expiry\":\""+expiry+"\"}";
		System.out.println(Constants.JSON_DATA);
		
		String jwt = "";
		try {
			jwt = RequestHelper.getCookieValue(request, "access_token");
			System.out.println("jwt="+jwt);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(jwt == null) {
			String clientId = request.getParameter("client_id");			
			String scope = request.getParameter("scope");
			String response_type = request.getParameter("response_type");
			String state = request.getParameter("state");
			String redirect_uri = request.getParameter("redirect_uri");
			
			String ssourl = Constants.IDP_AUTH_ENDPOINT+"?client_id="+clientId+"&scope="+scope+"&response_type="+response_type+"&state="+state+
					"&redirect_uri="+redirect_uri;

			response.sendRedirect(ssourl);
		} else {
			// make order with the jwt token
			try {
				
				String resp = RequestHelper.doOrder(jwt);

				request.getSession().setAttribute("resource", resp.trim());
				request.getRequestDispatcher("restview.jsp").forward(request, response);
			}catch(Exception e) {
				request.setAttribute("message", "\nSSO login failed!\n"+e.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
