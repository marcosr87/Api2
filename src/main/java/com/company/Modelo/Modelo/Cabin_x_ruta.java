package com.company.Modelo.Modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by alumno on 21/05/2018.
 */
@Getter
@Setter
@Entity
@Table(name = "cabin_x_ruta")
@NoArgsConstructor
public class Cabin_x_ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_cabin_x_ruta", nullable = false)
    private int Id_cabin_x_ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cabina_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cabina cabina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ruta_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ruta ruta;

    public Cabin_x_ruta (Cabina c, Ruta r)
    {
        this.cabina = c;
        this.ruta = r;
    }


}
