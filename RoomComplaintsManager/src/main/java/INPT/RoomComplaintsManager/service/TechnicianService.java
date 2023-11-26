
package INPT.RoomComplaintsManager.service;

import INPT.RoomComplaintsManager.Repositories.ComplaintRepository;
import INPT.RoomComplaintsManager.Repositories.TechnicianRepository;
import INPT.RoomComplaintsManager.model.Complaint;
import INPT.RoomComplaintsManager.model.Student;
import INPT.RoomComplaintsManager.model.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    public ResponseEntity<Object> authentifier(Technician technician) {

        try {
            technicianRepository.save(technician);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur");
        }
        return ResponseEntity.ok().body(technician);
    }


    public ResponseEntity<Object> verifier(Technician technician) {
        String userName= technician.getUserName();
        String password= technician.getPassword();
        Optional<Technician> technicianFound=technicianRepository.findByUserNameAndAndPassword(userName,password);
        if(technicianFound.isEmpty()){
            return ResponseEntity.ok().body("not found");
        }
        return ResponseEntity.ok().body("found");
    }

    public ResponseEntity<List<Map<String,Object>>> getAllComplaint() {
        List<Complaint> complaints=complaintRepository.findAll();
        List<Map<String,Object>> myComplaints=new ArrayList<>();
        for (Complaint complaint:complaints){
            Map<String,Object> complaint_json=new HashMap<>();
            complaint_json.put("numroom",complaint.getRoomNumber());
            complaint_json.put("pavillon",complaint.getPavillonNum());
            Student student=complaint.getStudent();
            complaint_json.put("name",student.getUsername());
            complaint_json.put("description",complaint.getDescription());
            myComplaints.add(complaint_json);
        }
      return ResponseEntity.status(HttpStatus.OK).body(myComplaints);
    }

}

