package k23CNT2.nvhLab06.service;


import k23CNT2.nvhLab06.dto.StudentDTO;
import k23CNT2.nvhLab06.entity.Student;
import k23CNT2.nvhLab06.repository.StudentRepositoty;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class StudentService {

    private StudentRepositoty studentRepositoty;

    @Autowired
    public StudentService(StudentRepositoty studentRepositoty) {
        this.studentRepositoty = studentRepositoty;
    }

    public List<Student> findAll() {
        return studentRepositoty.findAll();
    }

    public Optional<StudentDTO> findById(Long id) {
        Student student = studentRepositoty.findById(id).orElse(null);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setAge(student.getAge());
        return Optional.of(studentDTO);
    }

    public Boolean save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        try {
            studentRepositoty.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Student updateStudentById(Long id, StudentDTO updatedStudent) {
        return studentRepositoty.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            return studentRepositoty.save(student);
        }).orElseThrow(() -> new IllegalArgumentException("Invail student ID:" + id));
    }

    public void deleteStudent(Long id) {
        studentRepositoty.deleteById(id);
    }

}
