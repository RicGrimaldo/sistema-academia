package edu.uady.pagos.repository;

import edu.uady.pagos.entity.CostoMaterias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostoMateriasRepository extends JpaRepository<CostoMaterias, Long> {
    Optional<CostoMaterias> findCostoMateriasById(Long id);
}
