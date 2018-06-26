package com.company.Modelo.DTO;

import com.company.Modelo.Modelo.Aeropuertos;
import com.company.Modelo.Modelo.Ruta;
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
public class RutaDTO {



    @JsonProperty("IataOrigen")
    private String origin;

    @JsonProperty("IataDestino")
    private String destination;

    @JsonProperty ("IdRuta")
    private int Idruta;

    @JsonProperty("Distancia")
    private double Distancia;




    public RutaDTO(Aeropuertos origin, Aeropuertos destination, Ruta ruta) {

        this.origin = origin.getIATA();
        this.destination = destination.getIATA();
        this.Idruta = ruta.getId_ruta();
        this.Distancia = ruta.getDistance();

    }
}