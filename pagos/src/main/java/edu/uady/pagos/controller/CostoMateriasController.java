package edu.uady.pagos.controller;

import edu.uady.pagos.entity.CostoMaterias;
import edu.uady.pagos.error.ControlPagosException;
import edu.uady.pagos.service.CostoMateriasService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/costo-materia")
@Log4j2
public class CostoMateriasController {
    @Autowired
    private CostoMateriasService costoMateriasService;

    @GetMapping
    public ResponseEntity<?> getAllCostoMaterias() {
        try {
            return ResponseEntity.ok().body(costoMateriasService.getAllCostoMaterias());
        } catch (ControlPagosException e) {
            log.warn("Sin datos");
            log.error(e);
            return new ResponseEntity<>("Datos no encontrados", HttpStatus.OK);
        } catch (Exception exception) {
            log.error(exception);
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public CostoMaterias createCostoMaterias(@RequestBody CostoMaterias costoMaterias){
        log.info("Costo de materia  a guardar: "+costoMaterias.toString());
        return costoMateriasService.createCostoMaterias(costoMaterias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCostoMaterias(@RequestBody CostoMaterias costoMaterias) {
        log.info("Costo de materia a actualizar :"+ costoMaterias.toString());
        try {
            return  ResponseEntity.ok().body(costoMateriasService.updateCostoMaterias(costoMaterias));
        }catch (ControlPagosException ex){
            log.warn("Sin datos");
            log.error(ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCostoMaterias(@PathVariable (value = "id") Long id){
        costoMateriasService.deleteCostoMaterias(id);
    }
}
