package samplebatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import samplebatis.model.student.Student;
import samplebatis.model.student.StudentPayload;
import samplebatis.model.student.StudentsPayload;
import samplebatis.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student create(
            @RequestBody StudentPayload studentPayload
    ) {
        return studentService.create(studentPayload);
    }

    @GetMapping("/{studentId}")
    public Student read(
            @PathVariable Long studentId
    ) {
        return studentService.read(studentId);
    }

    @PutMapping("/{studentId}")
    public Student update(
            @PathVariable Long studentId,
            @RequestBody StudentPayload studentPayload
    ) {
        return studentService.update(studentId, studentPayload);
    }

    @DeleteMapping("/{studentId}")
    public void delete(
            @PathVariable Long studentId
    ) {
        studentService.delete(studentId);
    }

    @GetMapping
    public StudentsPayload customers() {
        return new StudentsPayload(studentService.students());
    }

}
