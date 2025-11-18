package com.wilian.Pescadito.service;

import com.wilian.Pescadito.model.Combinado;
import com.wilian.Pescadito.repositories.CombinadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CombinadoServices implements CombinadoSer {
    @Autowired
    private CombinadoRepo repo;


    @Override
    public List<Combinado> listar() {
        return repo.findAll();
    }

    @Override
    public Combinado buscarId(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Combinado crearCombinado(Combinado combinado) {
        return repo.save(combinado);
    }

    @Override
    public Combinado actualizarCombinado(Long id, Combinado combinado) {
        Combinado combinado1 = this.buscarId(id);
        combinado1.setNombre(combinado.getNombre());
        combinado1.setCategoria(combinado.getCategoria());
        combinado1.setDescripcion(combinado.getDescripcion());
        combinado1.setDisponible(combinado.isDisponible());
        combinado1.setPrecio(combinado.getPrecio());
        return repo.save(combinado1);
    }

    @Override
    public void eliminarCombinado(Long id) {
        repo.delete(this.buscarId(id));
    }

    @Override
    public     List<Combinado> combinadosdispo() {
        List<Combinado> all = repo.findAll();
        List<Combinado> collect = all.stream().filter(Combinado::isDisponible).collect(Collectors.toList());
        return collect;
    }
}
