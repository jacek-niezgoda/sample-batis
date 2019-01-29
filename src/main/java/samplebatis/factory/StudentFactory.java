package samplebatis.factory;

import org.springframework.stereotype.Service;
import samplebatis.entity.StudentEntity;
import samplebatis.model.student.Student;
import samplebatis.model.student.StudentPayload;

@Service
public class StudentFactory {
    public Student studentOf(StudentEntity entity) {
        if (entity==null) {
            return null;
        }
        return Student
                .builder()
                .studentId(entity.getStudentId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }

    public StudentEntity entityOf(Student student) {
        if (student==null) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setStudentId(student.studentId());
        studentEntity.setFirstName(student.firstName());
        studentEntity.setLastName(student.lastName());

        return studentEntity;
    }

    public StudentEntity entityOf(StudentPayload studentPayload) {
        return entityOf(null, studentPayload);
    }

    public StudentEntity entityOf(Long studentId, StudentPayload studentPayload) {
        if (studentPayload==null) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setStudentId(studentId);
        studentEntity.setFirstName(studentPayload.firstName());
        studentEntity.setLastName(studentPayload.lastName());

        return studentEntity;
    }
}
