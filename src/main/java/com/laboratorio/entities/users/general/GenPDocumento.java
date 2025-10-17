package com.laboratorio.entities.users.general;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gen_p_documento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenPDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Boolean habilita = true;

}
