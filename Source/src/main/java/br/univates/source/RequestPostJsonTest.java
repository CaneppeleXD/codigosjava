package br.univates.source;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

//https://www.baeldung.com/httpurlconnection-post
public class RequestPostJsonTest {
    public static void main(String[] args) {
        String url = "https://graph.facebook.com/v15.0/112614921661750/messages";
        String jsonInputString = "{   \"messaging_product\":\"whatsapp\",   \"to\":\"5551997171464\",   \"type\":\"template\",   \"template\":{      \"name\":\"hello_world\",      \"language\":{         \"code\":\"en_US\"      }}}";
        sendPost(url, jsonInputString);
    }

    public static void sendPost(String targetURL, String parameters) {
        String autorizacao = "Bearer EAAP8JlOfdJwBAH8yymNOMlCe0zbEZAE0nYja77ZAc08TPenIzlsspjr7ZCBQigx1cZB5Wrk9L8OZA5nVhZBTwuGmBOtYA8A9wGbZA2fWlzaX63ts3LdS5mm6qARt12U6VjJjO0uXgVYffzDMEC46fscyVjqyaR6ve6pV6dmcYpAl6xpBzfUX1MswV3224IbYxMIcFVcxRJF2QZDZD";
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            
            HttpPost request = new HttpPost(targetURL);
            StringEntity params = new StringEntity(parameters);
            request.addHeader("Authorization", autorizacao);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request); 
            System.out.println(response.getStatusLine());
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}