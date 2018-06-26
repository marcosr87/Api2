package com.company.Modelo.DTO;

import com.company.Modelo.Modelo.Cabina;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by alumno on 07/06/2018.
 */
@Setter
@Getter
@NoArgsConstructor
public class CabinaDTO {


    @JsonProperty("Idcabina")
    private int Idcabina;

    @JsonProperty("Name")
    private String name;



    public CabinaDTO(Cabina cabina) {

        this.Idcabina = cabina.getId_cabin();
        this.name = cabina.getName();

    }
}