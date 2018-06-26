package com.company.Modelo.Modelo;

import com.company.Modelo.DTO.CabinaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by alumno on 16/05/2018.
 */
@Getter
@Setter
@Entity
@Table(name = "cabin")
@NoArgsConstructor

public class Cabina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_cabin", nullable = false)
    private int Id_cabin;
    @NotEmpty(message = "Nombre Requerido")
    @Column(name = "Name", columnDefinition = "varchar(30)", nullable = false)
    private String name;

    public Cabina(CabinaDTO dto)
    {
        this.name = dto.getName();

    }
}
