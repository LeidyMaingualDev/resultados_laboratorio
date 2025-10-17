package com.laboratorio.entities.users.facturacion;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fac_p_cups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacPCups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String codigo;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Boolean habilita = true;
}
