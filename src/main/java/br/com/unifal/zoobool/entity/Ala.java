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
@Table(schema = "db2022108040", name = "animal")
public class Ala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_animal;

    private String tamanho;

    private String n_cientifico;

    private String especie;

    private String nome;

    private Integer id_habitat;

    private Integer id_vet;

    private Integer idade;

    private Float peso;


}
