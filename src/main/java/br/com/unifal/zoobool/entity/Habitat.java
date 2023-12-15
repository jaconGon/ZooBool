package br.com.unifal.zoobool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db2022108040", name = "habitat")
public class Habitat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_habitat;

    @ManyToOne
    @JoinColumn(name = "id_ala")
    private Ala id_ala;

    private Integer id_tratador;

    private String tipo;

    private Integer n_especies;

    private String horario_trat;
    
}
