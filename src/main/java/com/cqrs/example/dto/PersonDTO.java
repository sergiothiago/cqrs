package com.cqrs.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {


    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    @JsonProperty("firstName")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("lastName")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("gender")
    private String gender;
}