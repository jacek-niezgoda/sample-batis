package samplebatis.factory;

import org.springframework.stereotype.Service;
import samplebatis.entity.SchoolEntity;
import samplebatis.entity.StudentEntity;
import samplebatis.model.school.School;
import samplebatis.model.school.SchoolPayload;
import samplebatis.model.student.Student;
import samplebatis.model.student.StudentPayload;

@Service
public class SchoolFactory {
    public School schoolOf(SchoolEntity entity) {
        if (entity==null) {
            return null;
        }
        return School
                .builder()
                .id(entity.getId())
                .payload(
                        SchoolPayload
                                .builder()
                                .name(entity.getName())
                                .level(entity.getLevel())
                                .build()
                )
                .build();
    }

    public SchoolEntity entityOf(School school) {
        if (school==null) {
            return null;
        }

        SchoolEntity entity = new SchoolEntity();

        entity.setId(school.id());
        entity.setName(school.payload().name());
        entity.setLevel(school.payload().level());

        return entity;
    }

    public SchoolEntity entityOf(SchoolPayload payload) {
        return entityOf(null, payload);
    }

    public SchoolEntity entityOf(Long id, SchoolPayload payload) {
        if (payload==null) {
            return null;
        }

        SchoolEntity entity = new SchoolEntity();

        entity.setId(id);
        entity.setName(payload.name());
        entity.setLevel(payload.level());

        return entity;
    }
}
