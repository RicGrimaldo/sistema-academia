package edu.uady.pagos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
public class Pago {
    @Id
    @Column(name = "pago_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "alumno_id", nullable = false)
    private Long alumnoId;

    @Column(name = "materia_id", nullable = false)
    private Long materiaId;

    @Column(name = "fecha_pago", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaPago;

    @Column(name = "importe_pago", precision = 6, scale = 2, nullable = false)
    private Double importePago;
}
