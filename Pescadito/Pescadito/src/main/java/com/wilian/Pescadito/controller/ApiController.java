package com.wilian.Pescadito.controller;

import com.wilian.Pescadito.model.Combinado;
import com.wilian.Pescadito.service.CombinadoSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private CombinadoSer service;

    @GetMapping("/combinados")
    private List<Combinado> listar(){
        return this.service.listar();
    }

    @GetMapping("/combinados/{id}")
    private Combinado buscarID(@PathVariable Long id){
        return this.service.buscarId(id);
    }

    @PostMapping("/combinados")
    private Combinado crear(@RequestBody Combinado combinado){
        return this.service.crearCombinado(combinado);
    }

    @PutMapping("/combinados/{id}")
    private Combinado listar(@PathVariable Long id,@RequestBody Combinado combinado){
        return this.service.actualizarCombinado(id,combinado);
    }

    @DeleteMapping("combinados/{id}")
    private ResponseEntity<String> eliminar(@PathVariable Long id){
        this.service.eliminarCombinado(id);
        return ResponseEntity.ok("Combinado eliminado");
    }

    @GetMapping("/combinados/disponibles")
    private List<Combinado> combinadosDispo(){
        return this.service.combinadosdispo();
    }
}
