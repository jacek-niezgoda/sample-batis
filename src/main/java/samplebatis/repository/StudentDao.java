package samplebatis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import samplebatis.entity.StudentEntity;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    public Long create(StudentEntity studentEntity) {
        return  (Long) sqlMapClientTemplate.insert("Student.create", studentEntity);
    }

    public StudentEntity read(Long studentId) {
        return (StudentEntity) sqlMapClientTemplate.queryForObject("Student.read", studentId);
    }

    public int update(StudentEntity studentEntity) {
        return sqlMapClientTemplate.update("Student.update", studentEntity);
    }

    public int delete(Long studentId) {
        return sqlMapClientTemplate.delete("Student.delete", studentId);
    }

    public List<StudentEntity> all() {
        return sqlMapClientTemplate.queryForList("Student.all");
    }
}
