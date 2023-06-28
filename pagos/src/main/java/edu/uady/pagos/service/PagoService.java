package edu.uady.pagos.service;

import edu.uady.pagos.entity.CostoMaterias;
import edu.uady.pagos.entity.Pago;
import edu.uady.pagos.error.ControlPagosException;
import edu.uady.pagos.repository.PagoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Log4j2
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public Pago createPago(Pago pago){
        log.info("crea el pago: "+pago.toString());
        return pagoRepository.save(pago);
    }

    public Pago updatePago(Pago pago) throws Exception {
        Optional<Pago> optionalPago = pagoRepository.findById(pago.getId());
        if (optionalPago.isPresent()) {
            log.info("actualiza el pago: " + pago.toString());
            return pagoRepository.save(pago);
        }
        throw new ControlPagosException("No se encuentra el pago " + pago.toString());
    }

    public List<Pago> getAllPagos() throws Exception{
        List<Pago> pagos = pagoRepository.findAll();
        if(pagos.isEmpty()){
            throw new ControlPagosException("no se encontraron datos");
        }
        return  pagos;
    }

    public void deletePago(Long id){
        pagoRepository.deleteById(id);
    }
}
