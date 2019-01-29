package samplebatis.model.school;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableSchoolPayload.class)
@JsonDeserialize(as = ImmutableSchoolPayload.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface SchoolPayload {
    String name();
    String level();

    static ImmutableSchoolPayload.Builder builder() {
        return ImmutableSchoolPayload.builder();
    }
}
