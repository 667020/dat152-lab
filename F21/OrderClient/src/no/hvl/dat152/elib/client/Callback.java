package no.hvl.dat152.elib.client;

import java.io.IOException;
import java.util.Base64;

import no.hvl.dat152.elib.client.servlets.RequestHelper;
import no.hvl.dat152.elib.client.tokens.KeyCloakJwt;
import no.hvl.dat152.elib.client.tokens.KeyCloakTokenHandler;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;

/**
 * @author tdoy
 * Servlet implementation class Callback
 */
@WebServlet("/callback")
public class Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Callback() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idp_response = "";
		try {
			
			String code = request.getParameter("code");
			//String state = request.getParameter("state");		// not used here!
			
			// use the authorization_code to request for authentication token (JWT)
			// Authorization header contains the client_id and the client_secret with a post request
			
			String token_endpoint_url_data = "grant_type=authorization_code&code="+code+"&redirect_uri="+Constants.SP_CALLBACK_ADDRESS;

			// we will use a direct back channel to submit the request to the IdP			
			
			idp_response = RequestHelper.doRequestToken(token_endpoint_url_data);
			System.out.println(idp_response);
			
			//keycloak
			KeyCloakTokenHandler keycloakHandler = new KeyCloakTokenHandler(idp_response.trim());
			KeyCloakJwt keyCloakToken = keycloakHandler.getKeyCloakjwt();
			
			String access_token = keyCloakToken.getAccess_token();
			
			// save token in cookie
			Cookie tokencookie = new Cookie("access_token", keyCloakToken.getAccess_token());
			tokencookie.setMaxAge(100000);
			response.addCookie(tokencookie);
			
			// send order request to REST API Resource Server endpoint for user {id}
			String resp = RequestHelper.doOrder(access_token);
			
			request.getSession().setAttribute("resource", resp.trim());
			request.getRequestDispatcher("restview.jsp").forward(request, response);
			
		}catch(Exception e) {
			request.setAttribute("message", "\nSSO login failed!\n"+e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
