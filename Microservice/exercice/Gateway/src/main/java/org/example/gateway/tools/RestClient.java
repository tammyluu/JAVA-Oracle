package org.example.gateway.tools;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@FieldDefaults(level = AccessLevel.PACKAGE, makeFinal = true)
public class RestClient<T>{
    String urlApi ;
    RestTemplate template;
    HttpHeaders httpHeaders;

    public RestClient(String urlApi) {
        this.urlApi = urlApi;
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T postRequest(String json, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>(json,httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApi, HttpMethod.POST, requestEntity, type);
        if(response.hasBody()) {
            return response.getBody();
        }
        return null;
    }
    public T getRequest( Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("",httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApi, HttpMethod.GET, requestEntity, type);
        if(response.hasBody()) {
            return response.getBody();
        }
        return null;
    }
}
