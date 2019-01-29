package samplebatis.model.student;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableStudentPayload.class)
@JsonDeserialize(as = ImmutableStudentPayload.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface StudentPayload {
    String firstName();
    String lastName();

    static ImmutableStudentPayload.Builder builder() {
        return ImmutableStudentPayload.builder();
    }
}
