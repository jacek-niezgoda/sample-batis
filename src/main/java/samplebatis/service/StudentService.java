package samplebatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samplebatis.factory.StudentFactory;
import samplebatis.model.student.Student;
import samplebatis.model.student.StudentFilter;
import samplebatis.model.student.StudentPayload;
import samplebatis.repository.StudentDao;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentFactory studentFactory;

    public Student create(StudentPayload studentPayload) {
        return read(
                studentDao.create(
                        studentFactory.entityOf(studentPayload)
                )
        );
    }

    public Student read(Long studentId) {
        return studentFactory.studentOf(
                studentDao.read(studentId)
        );
    }

    public Student update(Long studentId, StudentPayload studentPayload) {
        studentDao.update(
                studentFactory.entityOf(studentId, studentPayload)
        );
        return read(studentId);
    }

    public void delete(Long studentId) {
        studentDao.delete(studentId);
    }

    public List<Student> list(StudentFilter filter) {
        return studentDao.list(filter)
                .stream()
                .map(studentFactory::studentOf)
                .collect(Collectors.toList());
    }
}
