/**
 * 
 */
package no.hvl.dat152.elib.client;


public class Constants {

	public static String CLIENT_ID = "order-client";								// this is the id you created on Keycloak Identity Provider
	public static String CLIENT_SECRET = "pQ8XGXOPNMrX4ETi6HBOmJlDuRJHCEhZ";		// this is issued to the client by the identity Provider during registration
	
	public static final String STATE = "abcdef";		// this should be a secure random number (not used in this example)
	
	public static final int IDP_PORT = 8080;
	public static final String IDP_AUTH_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/SpringBootKeycloak/protocol/openid-connect/auth";
	public static final String IDP_LOGOUT_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/SpringBootKeycloak/protocol/openid-connect/logout";
	public static final String IDP_TOKEN_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/SpringBootKeycloak/protocol/openid-connect/token";
	public static final String IDP_USERCLAIMS_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/SpringBootKeycloak/protocol/openid-connect/userinfo";
	public static final String IDP_REGISTER_ENDPOINT = "http://localhost:"+IDP_PORT+"/realms/SpringBootKeycloak/protocol/openid-connect/register";
	
	public static final String IDP_PATH = "/realms/SpringBootKeycloak";
	
	// client
	public static final int SP_CALLBACK_PORT = 9091;
	public static final String SP_ADDRESS = "http://localhost:"+SP_CALLBACK_PORT+"/orderclient";
	public static final String SP_CALLBACK_ADDRESS = "http://localhost:"+SP_CALLBACK_PORT+"/orderclient/callback";
	
	// REST API for order Resource endpoints
	public static String REST_ORDER_ENDPOINT;
	public static final String USER_ENDPOINT = "http://localhost:8090/elibrary/api/v1/users/";
	public static String JSON_DATA = "";
	
}
