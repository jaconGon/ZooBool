package br.com.unifal.zoobool.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db2022108040", name = "mamifero")
public class Mamifero extends Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_animal;

    private String tempo_gestacao;

    private String tempo_amam;
    
}
