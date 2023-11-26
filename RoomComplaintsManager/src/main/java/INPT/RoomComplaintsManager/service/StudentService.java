package INPT.RoomComplaintsManager.service;

import INPT.RoomComplaintsManager.Repositories.StudentRepository;

import INPT.RoomComplaintsManager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService  {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<Object> authentifier(Student student) {
        try{
            studentRepository.save(student);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erreur");
        }
        return ResponseEntity.ok().body(student);
    }

    public ResponseEntity<Object> verifier(Student student) {
         String userName= student.getUsername();
        String password= student.getPassword();
         Optional<Student> studentFound=studentRepository.findByUsernameAndPassword(userName, password);
         if(studentFound.isEmpty()){
             return ResponseEntity.ok().body("not found");
         }
         return ResponseEntity.ok().body("found");
    }
}
