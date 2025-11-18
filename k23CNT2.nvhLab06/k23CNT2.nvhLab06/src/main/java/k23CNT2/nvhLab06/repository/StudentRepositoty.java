package k23CNT2.nvhLab06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import k23CNT2.nvhLab06.entity.Student;

@Repository
public interface StudentRepositoty extends JpaRepository<Student, Long> {

}
