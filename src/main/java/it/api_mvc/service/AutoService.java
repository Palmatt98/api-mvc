package it.api_mvc.service;

import it.api_mvc.model.Auto;
import it.api_mvc.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public void saveAuto(Auto auto) {
        autoRepository.save(auto);
    }

    public List<Auto> getAutos() {
        List<Auto> autoList = autoRepository.findAll();
        return autoList;
    }

    public List<Auto> getAutosByCarburante(String carburante) {
        List<Auto> autoList = autoRepository.findByCarburante(carburante);
        return autoList;
    }

    public List<Auto> getAutosByMarca(String marca) {
        List<Auto> autoList = autoRepository.findByMarca(marca);
        return autoList;
    }

    public HttpStatus updateAuto(Auto auto) {
        //per aggiornare una riga, dobbiamo recuperla attraverso l'id
        Optional<Auto> autoOptional = autoRepository.findById(auto.getId());
        if (autoOptional.isPresent()) {
            //autoToUpdate rappresenta la riga effettiva sul database
            Auto autoToUpdate = autoOptional.get();
            //facciamo l'update
            autoToUpdate.setHp(auto.getHp());
            autoToUpdate.setModello(auto.getModello());
            autoToUpdate.setCarburante(auto.getCarburante());
            autoToUpdate.setMarca(auto.getMarca());

            //salviamo le modifiche sul db
            autoRepository.save(autoToUpdate);

            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
