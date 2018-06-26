package com.company.Modelo.Modelo;

import com.company.Modelo.DTO.EstadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by alumno on 16/05/2018.
 */
@Entity
@Table(name = "state", uniqueConstraints = { @UniqueConstraint(columnNames = {"Iata_code"})})
@Getter
@Setter
@NoArgsConstructor


public class Estado {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "Id_State", nullable = false)
    private int Id_state;

    @NotEmpty(message = "Iata requerido")
    @Column(name = "Iata_Code", columnDefinition = "varchar(3)",unique = true,nullable = false)
    private String Iata_code;

    @NotEmpty (message = "Nombre requerido")
    @Column(name = "Name", columnDefinition = "varchar(30)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "estado")
    private List<Ciudad> Listaciudades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pais_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pais pais;

    public Estado( String iata, String name) {

        this.Iata_code = Iata_code.toLowerCase();
        this.name = name;
    }

    public Estado(EstadoDTO dto, Pais pais) {
        this.Iata_code = dto.getIata().toLowerCase();
        this.name = dto.getName();
        this.pais = pais;


    }

   }
