package com.company.Modelo.Modelo;

import com.company.Modelo.DTO.AeropuertosDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by alumno on 16/05/2018.
 */

@Getter
@Setter
@RequiredArgsConstructor
@javax.persistence.Table( name = "airports", uniqueConstraints =  @UniqueConstraint(columnNames = {"IATA"}))
@Entity

public class Aeropuertos  {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Airport", nullable = false)
    private int Id_Aeropuerto;
    @NotEmpty (message = "Nombre requerido")
    @Column(name = "Name", columnDefinition = "varchar(30)", nullable = false)
     private String name;

    @NotEmpty(message = "Iata requerido")
    @Column(name = "IATA", columnDefinition = "varchar(3)",unique = true,nullable = false)
     private  String IATA;

    //@OneToMany(mappedBy = "Ruta")
   // private List<Ruta> Listarutas;

    @NotEmpty(message = "Latitud requerido")
    @Column(name = "Latitude", columnDefinition = "varchar(10)",nullable = false)
    private @Getter
    @Setter
    String latitude;

    @NotEmpty(message = "Longitud requerido")
    @Column(name = "Longitud", columnDefinition = "varchar(10)",nullable = false)
    private String longitud;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Ciudad_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ciudad ciudad;

    public Aeropuertos(AeropuertosDTO dto, Ciudad city) {
        this.IATA = dto.getIataCode();
        this.name = dto.getName();
        this.latitude = dto.getLatitude();
        this.longitud = dto.getLongitude();
        this.ciudad = city;
    }

}
