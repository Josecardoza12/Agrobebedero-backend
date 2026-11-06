package com.example.ms_instalaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "linea_bebedero")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaBebedero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String granja;

    @Column(nullable = false, length = 80)
    private String galpon;

    @Column(nullable = false, length = 80)
    private String linea;
}