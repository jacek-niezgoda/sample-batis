package samplebatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import samplebatis.model.school.School;
import samplebatis.model.school.SchoolPayload;
import samplebatis.model.school.SchoolsPayload;
import samplebatis.model.student.Student;
import samplebatis.model.student.StudentPayload;
import samplebatis.model.student.StudentsPayload;
import samplebatis.service.SchoolService;

@RestController
@RequestMapping(path = "/api/v1/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School create(
            @RequestBody SchoolPayload payload
    ) {
        return schoolService.create(payload);
    }

    @GetMapping("/{id}")
    public School read(
            @PathVariable Long id
    ) {
        return schoolService.read(id);
    }

    @PutMapping("/{id}")
    public School update(
            @PathVariable Long id,
            @RequestBody SchoolPayload payload
    ) {
        return schoolService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        schoolService.delete(id);
    }

    @GetMapping
    public SchoolsPayload list() {
        return new SchoolsPayload(schoolService.list());
    }
}
