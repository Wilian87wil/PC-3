package com.wilian.Pescadito.service;

import com.wilian.Pescadito.model.Combinado;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CombinadoSer {
    List<Combinado> listar();
    Combinado buscarId(Long id);
    Combinado crearCombinado(Combinado combinado);
    Combinado actualizarCombinado(Long id, Combinado combinado);
    void eliminarCombinado(Long id);
    List<Combinado> combinadosdispo();
}
