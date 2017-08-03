package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.List;

public interface ProvinciaService {

    Provincia buscarPorId(Long id);

    Provincia buscarPorNombre(String nombre);
    
    List<Provincia> buscarListaPorNombre(String nombre);

    List<Provincia> buscarListaDeProvinciasPorPais(String pais);

    List<Provincia> buscarTodos();

    void eliminarPorId(Long id);

    Provincia insertarProvincia(Provincia provincia);
}
