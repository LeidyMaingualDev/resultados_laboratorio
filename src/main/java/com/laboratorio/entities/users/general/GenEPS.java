package com.laboratorio.entities.users.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "gen_p_eps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenEPS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;

    @Column(nullable = false, unique = true, length = 20)
    private String nit;

    @Column(nullable = false)
    private Boolean habilita = true;
}
