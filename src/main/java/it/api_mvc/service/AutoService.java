package it.api_mvc.service;

import it.api_mvc.model.Auto;
import it.api_mvc.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
