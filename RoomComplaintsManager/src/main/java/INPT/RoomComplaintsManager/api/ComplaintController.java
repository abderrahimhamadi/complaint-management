package INPT.RoomComplaintsManager.api;


import INPT.RoomComplaintsManager.model.Complaint;
import INPT.RoomComplaintsManager.model.ComplaintToSave;
import INPT.RoomComplaintsManager.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/complaint")
    public ResponseEntity<String> saveComplaint(@RequestBody ComplaintToSave complaint){
                   return  complaintService.saveComplaint(complaint);
    }
}
