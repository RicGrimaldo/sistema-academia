package edu.uady.pagos.controller;

import edu.uady.pagos.entity.CostoMaterias;
import edu.uady.pagos.entity.Pago;
import edu.uady.pagos.error.ControlPagosException;
import edu.uady.pagos.service.PagoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pago")
@Log4j2
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<?> getAllPagos(){
        try{
            return ResponseEntity.ok().body(pagoService.getAllPagos());
        } catch (ControlPagosException e){
            log.warn("Sin datos");
            log.error(e);
            return new ResponseEntity<>("Datos no encontrados", HttpStatus.OK);
        } catch (Exception exception) {
            log.error(exception);
            throw new RuntimeException(exception);
        }
    }

    @PostMapping
    public Pago createPago(@RequestBody Pago pago){
        log.info("Pago  a guardar: "+pago.toString());
        return pagoService.createPago(pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePago(@RequestBody Pago pago) {
        log.info("Pago a actualizar :"+ pago.toString());
        try {
            return  ResponseEntity.ok().body(pagoService.updatePago(pago));
        }catch (ControlPagosException ex){
            log.warn("Sin datos");
            log.error(ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable (value = "id") Long id){
        pagoService.deletePago(id);
    }
}
