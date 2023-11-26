package INPT.RoomComplaintsManager.service;

import INPT.RoomComplaintsManager.Repositories.ComplaintRepository;
import INPT.RoomComplaintsManager.Repositories.StudentRepository;
import INPT.RoomComplaintsManager.model.Complaint;
import INPT.RoomComplaintsManager.model.ComplaintToSave;
import INPT.RoomComplaintsManager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private StudentRepository studentRepository;
    public ResponseEntity<String> saveComplaint(ComplaintToSave complaint) {
          Optional<Student> student=studentRepository.findByUsername(complaint.getUserName());
          if (student.isPresent()){
              Complaint complaint1=Complaint.builder()
                      .student(student.get())
                      .roomNumber(complaint.getRoomNumb())
                      .pavillonNum(complaint.getPavillon())
                      .description(complaint.getDescription())
                      .build();
              complaintRepository.save(complaint1);
               return ResponseEntity.ok().body("saved");
          }
         return ResponseEntity.ok().body("Not found");

    }
}
