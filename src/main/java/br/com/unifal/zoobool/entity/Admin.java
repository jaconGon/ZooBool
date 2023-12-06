package br.com.unifal.zoobool.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db", name = "admin")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_admin;

    @Column(name = "nome")
    private String nome;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
