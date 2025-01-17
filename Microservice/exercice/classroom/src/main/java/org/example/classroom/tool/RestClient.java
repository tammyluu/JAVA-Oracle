package org.example.classroom.tool;

import lombok.AccessLevel;

import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestClient <T>{
    String urlApi;
    RestTemplate template;
    HttpHeaders httpHeaders;

    public RestClient(String urlApi, RestTemplate template, HttpHeaders httpHeaders) {
        this.urlApi = urlApi;
        this.template = template;
        this.httpHeaders = httpHeaders;
    }
    public RestClient(String urlApi) {
        this.urlApi = urlApi;
        template = new RestTemplate();
        httpHeaders = new org.springframework.http.HttpHeaders();
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
