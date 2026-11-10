package th.ac.utc.shop.service;

import java.util.List;
import java.util.Optional;
import th.ac.utc.shop.model.Student;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findByID(Long id);
    Student save(Student student);
}
