package com.company.Modelo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by alumno on 21/06/2018.
 */
@Getter
@Setter
@NoArgsConstructor
public class EstadoDTO {

    @JsonProperty("Iata")
    private String Iata;

    @JsonProperty("name")
    private String name;

    @JsonProperty("Iso")
    private String Iso;

    public EstadoDTO(String iata, String name, String iso) {
        this.Iata = iata;
        this.name = name;
        this.Iso = iso;
    }

}
