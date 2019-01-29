package samplebatis.model.student;

import java.util.List;

public class StudentsPayload {
    private List<Student> students;

    public StudentsPayload(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
