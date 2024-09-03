package guru.springframework.spring5webapp.service;

import guru.springframework.spring5webapp.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public StudentDto addStudent(StudentDto studentDto);
    public StudentDto getStudentById(long id);
    public List<StudentDto> getAllStudents ();
    public StudentDto updateStudent(long id,StudentDto studentDto);
    public void deleteStudent(long id);

}
