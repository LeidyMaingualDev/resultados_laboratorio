package com.laboratorio.entities.users.facturacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.laboratorio.entities.users.general.GenEPS;
import com.laboratorio.entities.users.general.GenListaOpcion;
import com.laboratorio.entities.users.general.GenPersona;
import jakarta.persistence.*;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "fac_m_tarjetero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacMTarjetero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String historia;

    // Relación con persona
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private GenPersona persona;

    // Relación con régimen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_regimen", nullable = false)
    private GenListaOpcion regimen;

    // Relación con EPS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_eps", nullable = false)
    private GenEPS eps;

    // Relación con nivel
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel", nullable = false)
    private FacPNivel nivel;

}
