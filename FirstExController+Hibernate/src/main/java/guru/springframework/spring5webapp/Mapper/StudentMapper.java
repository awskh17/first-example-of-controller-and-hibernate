package guru.springframework.spring5webapp.Mapper;

import guru.springframework.spring5webapp.dto.StudentDto;
import guru.springframework.spring5webapp.entity.Student;

public class StudentMapper {

    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail());
    }

    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }


}
