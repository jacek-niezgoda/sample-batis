package samplebatis.model.school;

import java.util.List;

public class SchoolsPayload {
    private List<School> schools;

    public SchoolsPayload(List<School> schools) {
        this.schools = schools;
    }

    public List<School> getSchools() {
        return schools;
    }
}
