package INPT.RoomComplaintsManager.Repositories;

import INPT.RoomComplaintsManager.model.Student;
import INPT.RoomComplaintsManager.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Long> {

    Optional<Technician>  findByUserNameAndAndPassword(String username,String password);
}
