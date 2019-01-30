package samplebatis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import samplebatis.entity.SchoolEntity;
import samplebatis.model.school.SchoolFilter;

import java.util.List;

@Repository
public class SchoolDao {
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    public Long create(SchoolEntity entity) {
        return  (Long) sqlMapClientTemplate.insert("School.create", entity);
    }

    public SchoolEntity read(Long id) {
        return (SchoolEntity) sqlMapClientTemplate.queryForObject("School.read", id);
    }

    public int update(SchoolEntity entity) {
        return sqlMapClientTemplate.update("School.update", entity);
    }

    public int delete(Long id) {
        return sqlMapClientTemplate.delete("School.delete", id);
    }

    public List<SchoolEntity> list(SchoolFilter filter) {
        return sqlMapClientTemplate.queryForList("School.list", filter);
    }
}
