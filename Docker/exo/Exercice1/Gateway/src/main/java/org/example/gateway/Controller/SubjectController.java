package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.Dto.Subject.SubjectDtoReceive;
import org.example.gateway.Dto.Subject.SubjectDtoResponse;
import org.example.gateway.Tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/subject")
public class SubjectController {

    @Autowired
    ObjectMapper om;


    @GetMapping("/{id}")
    public ResponseEntity<SubjectDtoResponse> getById (@PathVariable("id") long id){
        RestClient<SubjectDtoResponse> subjectRestClient = new RestClient<>("http://localhost:8084/api/subject/"+id);
        SubjectDtoResponse subject = subjectRestClient.getRequest(SubjectDtoResponse.class);
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public ResponseEntity<SubjectDtoResponse> addSubject (@RequestBody SubjectDtoReceive subjectDtoReceive) throws JsonProcessingException {
        RestClient<SubjectDtoResponse> subjectRestClient = new RestClient<>("http://localhost:8084/api/subject");
        SubjectDtoResponse subject = subjectRestClient.postRequest(om.writeValueAsString(subjectDtoReceive),SubjectDtoResponse.class);
        return ResponseEntity.ok(subject);
    }
}
