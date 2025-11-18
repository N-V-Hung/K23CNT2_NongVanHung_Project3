package k23CNT2.nvhLab06.controller;


import k23CNT2.nvhLab06.dto.StudentDTO;
import k23CNT2.nvhLab06.entity.Student;
import k23CNT2.nvhLab06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService =studentService;
    }

    @GetMapping
    public String getStudents(Model model){
        model.addAttribute ("students", studentService.findAll());
        return  "students/student-list";
    }
    @GetMapping("/add-new")
    public String addNewStudnet (Model model){
        model.addAttribute("students", new Student());
        return "/students/student-add";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id,Model model){
        StudentDTO student = studentService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "students/student-edit";
    }

    @PostMapping("/update/{id}")
    public String updateStudent (@PathVariable(value = "id") Long id , @ModelAttribute("Student") StudentDTO student){
        studentService.updateStudentById(id,student);
        return "redirect:/students";
    }
    @GetMapping("/delete/{id}")
    public String ddeleteStdent (@PathVariable(value = "id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
