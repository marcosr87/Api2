package com.company.Modelo.Modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by alumno on 16/05/2018.
 */
@Getter
@Setter
@Entity
@Table(name = "route")
@NoArgsConstructor


public class Ruta {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "Id_Route", nullable = false)
    private int Id_ruta;

    @Column(name = "Distance",  nullable = false)
    private double distance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Origin_id_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Aeropuertos Aeropuertosorigin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Destination_id_fk",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Aeropuertos Aeropuertosdestine;

    public Ruta( Aeropuertos aeropuertosorigin, Aeropuertos aeropuertosdestine){
        this.Aeropuertosorigin = aeropuertosorigin;
        this.Aeropuertosdestine = aeropuertosdestine;
        this.distance = distance( Double.parseDouble(aeropuertosorigin.getLatitude()), Double.parseDouble( aeropuertosorigin.getLongitud()), Double.parseDouble( aeropuertosdestine.getLatitude()),Double.parseDouble(aeropuertosdestine.getLongitud()));
    }

    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

    public static double distance(double startLat, double startLong,
                                  double endLat, double endLong) {

        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

}
