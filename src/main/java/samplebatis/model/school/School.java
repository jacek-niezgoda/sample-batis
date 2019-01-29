package samplebatis.model.school;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import samplebatis.model.student.ImmutableStudent;

@Value.Immutable
@JsonSerialize(as = ImmutableSchool.class)
@JsonDeserialize(as = ImmutableSchool.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface School {
    Long id();
    @JsonUnwrapped
    SchoolPayload payload();

    static ImmutableSchool.Builder builder() {
        return ImmutableSchool.builder();
    }
}
