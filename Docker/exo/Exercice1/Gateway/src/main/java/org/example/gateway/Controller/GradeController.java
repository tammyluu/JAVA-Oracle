package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.Dto.Grade.GradeDtoReceive;
import org.example.gateway.Dto.Grade.GradeDtoResponse;
import org.example.gateway.Tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/grade")
public class GradeController {

    @Autowired
    ObjectMapper om;

    @GetMapping("/{id}")
    public ResponseEntity<GradeDtoResponse> getById (@PathVariable("id") long id) {
        RestClient<GradeDtoResponse> gradeDtoResponseRestClient = new RestClient<>("http://localhost:8085/api/grade/"+id);
        GradeDtoResponse gradeDtoResponse = gradeDtoResponseRestClient.getRequest(GradeDtoResponse.class);
        return ResponseEntity.ok(gradeDtoResponse);
    }
    @PostMapping
    public ResponseEntity<GradeDtoResponse> addGrade (@RequestBody GradeDtoReceive gradeDtoReceive) throws JsonProcessingException {
        RestClient<GradeDtoResponse> gradeDtoResponseRestClient = new RestClient<>("http://localhost:8085/api/grade");
        GradeDtoResponse gradeDtoResponse = gradeDtoResponseRestClient.postRequest(om.writeValueAsString(gradeDtoReceive),GradeDtoResponse.class);
        return ResponseEntity.ok(gradeDtoResponse);
    }
}
