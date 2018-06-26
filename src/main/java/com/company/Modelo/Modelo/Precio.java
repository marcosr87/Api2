package com.company.Modelo.Modelo;

import com.company.Modelo.DTO.PrecioDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alumno on 16/05/2018.
 */
@Getter
@Setter
@Entity
@Table(name = "price")
@NoArgsConstructor

public class Precio implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_cabin_x_ruta_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cabin_x_ruta cabin_x_ruta;
    //@Id
    //@JoinColumn(name = "Id_cabin_x_ruta_fk", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fromd ", nullable = false)
    private Date fromd;

    //@NotBlank(message = "Fecha requerida")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fromh ", nullable = false)
    private Date fromh;

   // @NotEmpty(message =  "Precio requerido")
    @Column( name = "Price", nullable = false)
    private double price;

    public Precio (Cabin_x_ruta cabin_x_ruta ,PrecioDTO dto)
    {
        this.cabin_x_ruta = cabin_x_ruta;
        this.fromd = dto.getFromd();
        this.fromh = dto.getFromh();
        this.price = dto.getPrecio();
    }
}
