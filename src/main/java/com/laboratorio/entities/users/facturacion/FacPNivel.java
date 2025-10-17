package com.laboratorio.entities.users.facturacion;

import com.laboratorio.entities.users.general.GenEPS;
import com.laboratorio.entities.users.general.GenListaOpcion;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "fac_p_nivel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacPNivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con EPS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_eps", nullable = false)
    private GenEPS eps;

    // Nivel de cobertura
    @Column(length = 10, nullable = false)
    private String nivel;

    // Nombre del nivel o plan
    @Column(length = 100, nullable = false)
    private String nombre;

    // Relación con lista de opciones régimen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_regimen", nullable = false)
    private GenListaOpcion regimen;
}
