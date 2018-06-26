package com.company.Modelo.DTO;

/**
 * Created by alumno on 06/06/2018.
 */
import com.company.Modelo.Modelo.Aeropuertos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AeropuertosDTO {

    @JsonProperty("Iata")
    private String iataCode;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitud")
    private String longitude;

    @JsonProperty("IataCity")
    private String city_iataCode;

    public AeropuertosDTO(String iataCode, String name, String latitude, String longitude, String city_iataCode) {
        this.iataCode = iataCode;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city_iataCode = city_iataCode;
    }

    public AeropuertosDTO( Aeropuertos airport) {
        this.iataCode = airport.getIATA().toLowerCase();
        this.name = airport.getName();
        this.latitude = airport.getLatitude();
        this.longitude = airport.getLongitud();
        this.city_iataCode = airport.getCiudad().getIata_code().toLowerCase();
    }
}