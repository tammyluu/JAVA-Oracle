package org.example.matiere.Service;

import org.example.matiere.Dto.SubjectDtoReceive;
import org.example.matiere.Dto.SubjectDtoResponse;
import org.example.matiere.Entity.Subject;
import org.example.matiere.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectDtoResponse save (SubjectDtoReceive subjectDtoReceive){
        Subject subject = dtoToSubject(subjectDtoReceive);
        subjectRepository.save(subject);
        return subjectToDto(subject);
    }

    public SubjectDtoResponse getById (long id){
        return subjectToDto(subjectRepository.findById(id).orElse(null));
    }

    public Subject dtoToSubject (SubjectDtoReceive subjectDtoReceive){
        return new Subject(subjectDtoReceive.getNom(),subjectDtoReceive.getCoef());
    }
    public SubjectDtoResponse subjectToDto (Subject subject){
        return new SubjectDtoResponse(subject.getId(),subject.getName(),subject.getCoef());
    }

}
