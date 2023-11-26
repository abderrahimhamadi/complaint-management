package INPT.RoomComplaintsManager.api;


import INPT.RoomComplaintsManager.model.Student;
import INPT.RoomComplaintsManager.model.Technician;
import INPT.RoomComplaintsManager.service.StudentService;
import INPT.RoomComplaintsManager.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/technician")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @PostMapping(value = "/signin")
    public ResponseEntity<Object> authentifier(@RequestBody Technician technician) {
        return technicianService.authentifier(technician);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> verifier(@RequestBody Technician technician) {
        return technicianService.verifier(technician);
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<Map<String,Object>>> getAllComplaint( ){
        return  technicianService.getAllComplaint();
    }
}
