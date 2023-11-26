package INPT.RoomComplaintsManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "Text")
    private String description ;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name="student_id",
            referencedColumnName = "studentId"
    )
    private Student student;

    private int roomNumber;

    private int pavillonNum;

}
