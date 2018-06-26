package com.company.Modelo.Modelo;

import com.company.Modelo.DTO.CiudadDTO;
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
@Table(name = "city",uniqueConstraints = @UniqueConstraint( columnNames = {"Iata_Code"}))
@Getter
@Setter
@NoArgsConstructor

public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_City", nullable = false)
    private int Id_city;

    @NotEmpty (message = "Iata requerido")
    @Column(name = "Iata_Code", columnDefinition = "varchar(3)", unique = true, nullable = false)
    private String Iata_code;

    @NotEmpty (message = "Nombre ciudad requerido")
    @Column(name = "Name",columnDefinition = "varchar(30)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "ciudad")
    private List<Aeropuertos> Listaaeropuertos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Estado_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Estado estado;

    public Ciudad ( String iata, String name) {

        this.Iata_code = Iata_code.toLowerCase();
        this.name = name;
    }

    public Ciudad(CiudadDTO dto, Estado estado) {
        this.Iata_code = dto.getIataCode().toLowerCase();
        this.name = dto.getName();
        this.estado = estado;

    }



}
