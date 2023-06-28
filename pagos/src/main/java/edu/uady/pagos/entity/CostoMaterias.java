package edu.uady.pagos.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "costo_materias")
@Data
@NoArgsConstructor
public class CostoMaterias {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "materia_id", unique = true, nullable = false)
    private String materiaId;

    @Column(name = "costo", precision = 6, scale = 2, nullable = false)
    private Double costo;
}
