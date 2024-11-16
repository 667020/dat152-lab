/**
 * 
 */
package no.hvl.dat152.elib.client.tokens;

import com.google.gson.Gson;

/**
 * @author tdoy
 */
public class KeyCloakTokenHandler {

	
	private KeyCloakJwt keyCloakjwt;
	/*
	 * format of keycloak received token after successful negotiation
	 * json = {"access_token":"value","expires_in":"value","refresh_expires_in":"value","refresh_token":"value"}
	 */
	
	public KeyCloakTokenHandler(String token) {
		Gson gson = new Gson();
		keyCloakjwt = gson.fromJson(token, KeyCloakJwt.class); 
	}

	/**
	 * @return the keyCloakjwt
	 */
	public KeyCloakJwt getKeyCloakjwt() {
		return keyCloakjwt;
	}
}
