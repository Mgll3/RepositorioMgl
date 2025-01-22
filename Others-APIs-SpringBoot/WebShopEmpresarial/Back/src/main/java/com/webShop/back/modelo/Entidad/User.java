package com.webShop.back.modelo.Entidad;


import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Table(name ="user")
@Data
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30 , nullable = false)
    private String name;

    @Column(length = 30 , nullable = false)
    private String lastname;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(name = "password", length = 100 , nullable = false)
    private String password;

    @ManyToOne
    private UserType userType;

}
