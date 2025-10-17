package com.laboratorio.repositories.facturacion;

import com.laboratorio.entities.users.facturacion.FacPNivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacPNivelRepository extends JpaRepository<FacPNivel, Long> {
}
