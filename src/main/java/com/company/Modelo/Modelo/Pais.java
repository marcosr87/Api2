package com.company.Modelo.Modelo;

import com.company.Modelo.DTO.PaisDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by alumno on 16/05/2018.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "country", uniqueConstraints = {@UniqueConstraint(columnNames = {"Iso"})})
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Country" , nullable = false)
    private int Id_Country;
    @NotEmpty(message = "Nombre Requerido")
    @Column(name = "Name", columnDefinition = "varchar(30)", nullable = false)
    private String name;
    @NotEmpty ( message = "Iso requerido" )
    @Column(name = "Iso", columnDefinition = "varchar(3)", unique = true, nullable = false)
    private String Iso;

    @OneToMany( mappedBy = "pais")
    private List<Estado> ListaEstado;

    public Pais( String isoCode, String name) {

        this.Iso = isoCode.toLowerCase();
        this.name = name;
    }

    public Pais(PaisDTO dto) {
        this.Iso = dto.getIsoCode().toLowerCase();
        this.name = dto.getName();
    }

}
