package com.laboratorio.repositories.general;

import com.laboratorio.entities.users.general.GenPersona;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenPersonaRepository extends JpaRepository<GenPersona, Long> {
}
