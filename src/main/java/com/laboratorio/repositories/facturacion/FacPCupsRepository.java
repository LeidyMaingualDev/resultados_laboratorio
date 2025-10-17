package com.laboratorio.repositories.facturacion;

import com.laboratorio.entities.users.facturacion.FacPCups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacPCupsRepository extends JpaRepository<FacPCups, Long> {
}
