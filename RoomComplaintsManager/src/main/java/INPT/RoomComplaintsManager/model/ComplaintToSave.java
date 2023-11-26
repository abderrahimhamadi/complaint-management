package INPT.RoomComplaintsManager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComplaintToSave {

    private String userName;
    private int  roomNumb;
    private int  pavillon;
    private String description;

}
