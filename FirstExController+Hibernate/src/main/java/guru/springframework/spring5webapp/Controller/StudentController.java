package guru.springframework.spring5webapp.Controller;


import guru.springframework.spring5webapp.dto.StudentDto;
import guru.springframework.spring5webapp.entity.Student;
import guru.springframework.spring5webapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    //add new Student
    private ResponseEntity<StudentDto> CreateStudent(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto);
       StudentDto savedStudent= studentService.addStudent(studentDto);
       return new ResponseEntity<>( savedStudent , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    //get student by Id
    private ResponseEntity<StudentDto> GetStudentById(@PathVariable int id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping()
    //get All students
    private ResponseEntity<List<StudentDto>> GetAllStudents() {
        List<StudentDto> studentsDtoList = studentService.getAllStudents();
        return ResponseEntity.ok(studentsDtoList);
    }

    @PutMapping("{id}")
    //update a student
    private ResponseEntity<StudentDto> UpdateStudent(@PathVariable int id, @RequestBody StudentDto studentDto) {
        StudentDto updatedStudentDto = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(updatedStudentDto);
    }

    @DeleteMapping("{id}")
    //delete student with id
    private HttpStatus DeleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return HttpStatus.OK;
    }

}
