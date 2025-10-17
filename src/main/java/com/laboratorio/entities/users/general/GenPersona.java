package com.laboratorio.entities.users.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "gen_m_persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con gen_p_lista_opcion (tipo de identificación)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_identificacion")
    private GenListaOpcion tipoIdentificacion;

    @Column(name = "numero_identificacion", nullable = false, unique = true, length = 20)
    private String numeroIdentificacion;

    @Column(name = "apellido1", nullable = false, length = 30)
    private String apellido1;

    @Column(name = "apellido2", length = 30)
    private String apellido2;

    @Column(name = "nombre1", nullable = false, length = 30)
    private String nombre1;

    @Column(name = "nombre2", length = 30)
    private String nombre2;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    // Relación con gen_p_lista_opcion (sexo biológico)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sexo_biologico")
    private GenListaOpcion sexoBiologico;

    @Column(length = 150)
    private String direccion;

    @Column(name = "telefono_movil", length = 20)
    private String telefonoMovil;

    @Column(nullable = false, unique = true, length = 100)
    private String email;
}