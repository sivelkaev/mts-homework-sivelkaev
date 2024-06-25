package mts.homework.sivelkaev.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindOlderAnimalResponse {
    @JsonProperty("animals")
    List<AnimalParam> animals;

    @Builder
    public static final class AnimalParam {
        @JsonProperty("animal")
        private AnimalDtoResponse animal;

        @JsonProperty("age")
        private Integer age;
    }
}
