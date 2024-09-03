package guru.springframework.spring5webapp.Repository;

import guru.springframework.spring5webapp.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
