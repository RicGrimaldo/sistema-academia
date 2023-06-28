package edu.uady.pagos.repository;

import edu.uady.pagos.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    Optional<Pago> findPagoById(Long id);
}
