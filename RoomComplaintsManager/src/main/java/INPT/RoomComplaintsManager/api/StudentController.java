package INPT.RoomComplaintsManager.api;
import INPT.RoomComplaintsManager.model.Student;
import INPT.RoomComplaintsManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private final StudentService studentservice;

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<Object> authentifier(@RequestBody Student student){
        return studentservice.authentifier(student);
    }
    @PostMapping (value = "/login")
    public ResponseEntity<Object> verifier(@RequestBody Student student){
        return studentservice.verifier(student);

}}
