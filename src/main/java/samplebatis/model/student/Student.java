package samplebatis.model.student;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableStudent.class)
@JsonDeserialize(as = ImmutableStudent.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Student {
    Long studentId();
    @JsonUnwrapped
    StudentPayload studentPayload();

    static ImmutableStudent.Builder builder() {
        return ImmutableStudent.builder();
    }
}
