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
public class CiudadDTO {

    @JsonProperty("Iata")
    private String iataCode;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("IataState")
    private String iataCodeState;

    public CiudadDTO(String iataCode, String name, String iataCodeState) {
        this.iataCode = iataCode;
        this.name = name;
        this.iataCodeState = iataCodeState;
    }
}
