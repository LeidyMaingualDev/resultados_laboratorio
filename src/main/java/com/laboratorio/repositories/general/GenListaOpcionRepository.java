package com.laboratorio.repositories.general;

import com.laboratorio.entities.users.general.GenListaOpcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface GenListaOpcionRepository extends JpaRepository<GenListaOpcion, Long> {
    List<GenListaOpcion> findByCategoria(String categoria);
}
