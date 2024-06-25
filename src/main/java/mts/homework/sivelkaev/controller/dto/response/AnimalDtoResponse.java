package mts.homework.sivelkaev.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalDtoResponse {
    @JsonProperty("type")
    private String type;

    @JsonProperty("breed")
    private String breed;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cost")
    private Double cost;

    @JsonProperty("character")
    private String character;

    @JsonProperty("birthDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;
}
