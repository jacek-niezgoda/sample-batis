package samplebatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samplebatis.factory.SchoolFactory;
import samplebatis.model.school.School;
import samplebatis.model.school.SchoolPayload;
import samplebatis.repository.SchoolDao;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private SchoolFactory schoolFactory;

    public School create(SchoolPayload payload) {
        return read(
                schoolDao.create(
                        schoolFactory.entityOf(payload)
                )
        );
    }

    public School read(Long id) {
        return schoolFactory.schoolOf(
                schoolDao.read(id)
        );
    }

    public School update(Long id, SchoolPayload payload) {
        schoolDao.update(
                schoolFactory.entityOf(id, payload)
        );
        return read(id);
    }

    public void delete(Long id) {
        schoolDao.delete(id);
    }

    public List<School> list() {
        return schoolDao.list()
                .stream()
                .map(schoolFactory::schoolOf)
                .collect(Collectors.toList());
    }
}
