package no.hvl.dat152.elib.client;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * @author tdoy
 */

public class HttpClient {
	
	private String endpoint;
	private String contentType;
	
	public HttpClient(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public String doHttpPost(String token, String jsonmsg) {
		
		MediaType contentType = MediaType.parse(getContentType());
		
		OkHttpClient client = new OkHttpClient();
		
		RequestBody body = RequestBody.create(contentType, jsonmsg);
		
		Request request = new Request.Builder()
				.url(endpoint)
				.addHeader("Authorization", token)
				.post(body)
				.build();

		System.out.println(request.toString());

		try (Response response = client.newCall(request).execute()) {
			String resp = response.body().string();
			System.out.println(resp);
			
			return resp;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
