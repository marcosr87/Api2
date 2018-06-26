package com.company.Modelo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by alumno on 07/06/2018.
 */

@Getter
@Setter
@NoArgsConstructor
public class PrecioDTO {

    @JsonProperty("IdCabinaxruta")
    private int id_cabin_x_ruta;

    @JsonProperty("Precio")
    private double precio;

    @JsonProperty("PrecioDesde")
    private Date fromd;

    @JsonProperty("PrecioHasta")
    private Date  fromh;

    public PrecioDTO(int id, double precio, Date fromd, Date fromh) {
        this.id_cabin_x_ruta = id;
        this.precio = precio;
        this.fromd = fromd;
        this.fromh = fromh;
    }
}