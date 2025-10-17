package com.laboratorio.entities.users.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "gen_p_lista_opcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenListaOpcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false, length = 20)
    private String valor;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String abreviatura;

    @Column(nullable = false, length = 400)
    private String descripcion;

    @Column(nullable = false)
    private boolean habilita;
}
