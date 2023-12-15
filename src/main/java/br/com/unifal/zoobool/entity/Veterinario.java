package br.com.unifal.zoobool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db2022108040", name = "veterinario")
public class Veterinario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vet;

    private Integer id_func;

    private String dias_de_plantao;

    private String especialidade;
}
