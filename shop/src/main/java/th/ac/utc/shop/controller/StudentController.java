package th.ac.utc.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.shop.model.Student;
import th.ac.utc.shop.service.StudentService;
import th.ac.utc.shop.service.InMemoryStudentService;
import java.util.List;
@RestController

public class StudentController {
    private final StudentService studentService = new InMemoryStudentService();

@GetMapping("/students")
public List<Student> list() {
    return studentService.findAll();
}
@GetMapping("/student")
public Student one(@RequestParam Long id) {
    return studentService.findByID(id).orElse(null);
}
}