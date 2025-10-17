package com.laboratorio.repositories.facturacion;

import com.laboratorio.entities.users.facturacion.FacMTarjetero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacMTarjeteroRepository extends JpaRepository<FacMTarjetero, Long> {
}
