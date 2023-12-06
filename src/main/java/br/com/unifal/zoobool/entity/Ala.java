package br.com.unifal.zoobool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db2022108040", name = "ala")
public class Ala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ala;

    private String tamanho;

    @OneToMany(mappedBy = "id_ala")
    private List<Habitat> habitats;

}
