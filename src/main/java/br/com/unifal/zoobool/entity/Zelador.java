package br.com.unifal.zoobool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db2022108040", name = "zelador")
public class Zelador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_zelador;

    private Integer id_func;

    private String tipo_func;

}
