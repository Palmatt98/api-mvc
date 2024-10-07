package it.api_mvc.controller;

import it.api_mvc.model.Auto;
import it.api_mvc.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping("/auto")
    public ResponseEntity<Void> saveAuto(@RequestBody Auto auto) {
        autoService.saveAuto(auto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/auto")
    public ResponseEntity<List<Auto>> getListAuto() {
        List<Auto> listAuto = autoService.getAutos();
        return new ResponseEntity<>(listAuto, HttpStatus.OK);
    }

    @GetMapping("/auto/{carburante}")
    public ResponseEntity<List<Auto>> getListAutoByCarburante(@PathVariable String carburante) {
        List<Auto> listAuto = autoService.getAutosByCarburante(carburante);
        return new ResponseEntity<>(listAuto, HttpStatus.OK);
    }

    //Ho messo marca prima di {marca} perche altrimenti /auto/{marca} va in conflitto con /auto/{carburante} perchè ricordiamo che le parentesi graffe rendono dinamico l'endpoint
    @GetMapping("/auto/marca/{marca}")
    public ResponseEntity<List<Auto>> getListAutoByMarca(@PathVariable String marca) {
        List<Auto> listAuto = autoService.getAutosByMarca(marca);
        return new ResponseEntity<>(listAuto, HttpStatus.OK);
    }

    @PutMapping("/auto")
    public ResponseEntity<Void> updateAuto(@RequestBody Auto auto) {
        HttpStatus result = autoService.updateAuto(auto);
        return new ResponseEntity<>(result);

    }
}
