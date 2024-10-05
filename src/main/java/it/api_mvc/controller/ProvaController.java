package it.api_mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProvaController {

    @GetMapping("/hello")
    public ResponseEntity<String> saluta() {
        return new ResponseEntity<>("ciao birbante", HttpStatus.OK);
    }

    @PostMapping("/hello")
    public ResponseEntity<String> testPost() {
        return new ResponseEntity<>("sono il metodo post", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> getList() {
        List<String> autos = new ArrayList<>();
        autos.add("maserati");
        autos.add("audi");
        autos.add("porche");
        autos.add("fiat");
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

}
