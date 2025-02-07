package org.example.classeroom.Tools;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RestClient<T> {
    private String urlApi ;
    private RestTemplate template;
    private HttpHeaders httpHeaders;

    public RestClient(String urlApi) {
        this.urlApi = urlApi;
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }
    public T getRequest( Class<T> type, String endpoint) {
        HttpEntity<String> requestEntity = new HttpEntity<>("",httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApi, HttpMethod.GET, requestEntity, type);
        if(response.hasBody()) {
            return response.getBody();
        }
        return null;
    }

}
