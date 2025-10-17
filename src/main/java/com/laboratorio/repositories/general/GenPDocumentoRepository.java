package com.laboratorio.repositories.general;

import com.laboratorio.entities.users.general.GenPDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenPDocumentoRepository extends JpaRepository<GenPDocumento, Long> {
}
