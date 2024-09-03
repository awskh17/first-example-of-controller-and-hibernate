package guru.springframework.spring5webapp.service.Impl;

import guru.springframework.spring5webapp.Exception.NotFoundException;
import guru.springframework.spring5webapp.Mapper.StudentMapper;
import guru.springframework.spring5webapp.Repository.StudentRepository;
import guru.springframework.spring5webapp.dto.StudentDto;
import guru.springframework.spring5webapp.entity.Student;
import guru.springframework.spring5webapp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    //add new Student
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    //get student by Id
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new NotFoundException("Student with "+id+" not found "));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    //get All students
    public List<StudentDto> getAllStudents() {
        List<Student> students= (List<Student>) studentRepository.findAll();
        return students.stream().map(s -> StudentMapper.mapToStudentDto(s)).collect(Collectors.toList());
    }

    @Override
    //update a student
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new NotFoundException("Student with "+id+" not found "));
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudent);
    }

    @Override
    //delete student with id
    public void deleteStudent(long id) {
        Student student =studentRepository.findById(id).orElseThrow(()->new NotFoundException("Student with "+id+" not found "));
        studentRepository.deleteById(id);
    }


}
