package INPT.RoomComplaintsManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;

    @OneToMany(
            mappedBy = "student"
    )
    List<Complaint> complaints;

    private int roomNumber;

}
