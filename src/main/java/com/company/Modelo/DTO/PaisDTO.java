package com.company.Modelo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by alumno on 07/06/2018.
 */
@Getter
@Setter
@NoArgsConstructor
public class PaisDTO {

    @JsonProperty("isoCode")
    private String isoCode;

    @JsonProperty("name")
    private String name;

    public PaisDTO(String isoCode, String name) {
        this.isoCode = isoCode;
        this.name = name;
    }
}
