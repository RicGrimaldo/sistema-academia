package edu.uady.pagos.service;

import edu.uady.pagos.entity.CostoMaterias;
import edu.uady.pagos.error.ControlPagosException;
import edu.uady.pagos.repository.CostoMateriasRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CostoMateriasService {
    @Autowired
    private CostoMateriasRepository costoMateriasRepository;

    public CostoMaterias createCostoMaterias(CostoMaterias costoMaterias){
        log.info("crea el costo de la materia: "+costoMaterias.toString());
        return costoMateriasRepository.save(costoMaterias);
    }

    public CostoMaterias updateCostoMaterias(CostoMaterias costoMaterias) throws Exception {
        Optional<CostoMaterias> optionalCostoMaterias = costoMateriasRepository.findCostoMateriasById(costoMaterias.getId());
        if (optionalCostoMaterias.isPresent()) {
            log.info("actualiza el costo de la materia: " + costoMaterias.toString());
            return costoMateriasRepository.save(costoMaterias);
        }
        throw new ControlPagosException("No se encuentra el costo de la materia " + costoMaterias.toString());
    }

    public List<CostoMaterias> getAllCostoMaterias() throws Exception{
        List<CostoMaterias> costoMaterias = costoMateriasRepository.findAll();
        if(costoMaterias.isEmpty()){
            throw new ControlPagosException("no se encontraron datos");
        }
        return  costoMaterias;
    }

    public void deleteCostoMaterias(Long id){
        costoMateriasRepository.deleteById(id);
    }
}
