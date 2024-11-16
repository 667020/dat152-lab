package no.hvl.dat152.elib.client.controllers;


import java.util.Base64;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat152.elib.client.Constants;
import no.hvl.dat152.elib.client.HttpClient;

public class RequestHelper {

	public static String getCookieValue(HttpServletRequest request,
			String cookieName) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName.trim())) {
					return c.getValue();
				}
			}
		}
		return null;
	}
	
	public static Cookie getCookie(HttpServletRequest request,
			String cookieName) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName.trim())) {
					return c;
				}
			}
		}
		return null;
	}
	
	/**
	 * Method to make order to /users/{id}/orders Or /orders REST endpoints
	 * @param accesstoken
	 * @return
	 */
	public static String doOrder(String accesstoken) {
		
		HttpClient http = new HttpClient(Constants.REST_ORDER_ENDPOINT);
		
		http.setContentType("application/json; charset=utf-8");
		String header = "Bearer "+accesstoken;
		String resp = http.doHttpPost(header, Constants.JSON_DATA);
		
		return resp;
	}
	
	/**
	 * Method to request for access_token from the IdP
	 * @param tokenurl
	 * @return
	 */
	public static String doRequestToken(String tokenurldata) {
		
		HttpClient httpChannel = new HttpClient(Constants.IDP_TOKEN_ENDPOINT);
		
		String clientid = Constants.CLIENT_ID+":"+Constants.CLIENT_SECRET;
		String client_credentials = Base64.getUrlEncoder().encodeToString(clientid.getBytes());
		String header = "Basic "+client_credentials;
		httpChannel.setContentType("application/x-www-form-urlencoded");
		
		String idp_response = httpChannel.doHttpPost(header, tokenurldata);
		
		return idp_response;
	}

}
