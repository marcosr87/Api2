package com.company.Modelo.DTO;

import com.company.Modelo.Modelo.Cabina;
import com.company.Modelo.Modelo.Ruta;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by alumno on 24/06/2018.
 */
@Setter
@Getter
@NoArgsConstructor

public class CabinaxrutaDTO {

    @JsonProperty("IdCabina")
    private int Idcabina;

    @JsonProperty("IdRuta")
    private int IdRuta;

    public CabinaxrutaDTO (Cabina c, Ruta r)
    {
        this.Idcabina = c.getId_cabin();
        this.IdRuta = r.getId_ruta();
    }
}
