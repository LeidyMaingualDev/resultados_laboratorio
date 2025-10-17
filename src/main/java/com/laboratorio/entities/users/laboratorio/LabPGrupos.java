package com.laboratorio.entities.users.laboratorio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lab_p_grupos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabPGrupos {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Boolean habilita = true;
}
