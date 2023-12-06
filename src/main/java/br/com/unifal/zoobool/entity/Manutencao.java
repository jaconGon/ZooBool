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
@Table(schema = "db2022108040", name = "manutencao")
public class Manutencao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ala;

    private Integer id_zelador;

    @ManyToOne
    @JoinColumn(name = "id_zelador")
    private Zelador zelador;

    @ManyToOne
    @JoinColumn(name = "id_ala")
    private Ala ala;



}
