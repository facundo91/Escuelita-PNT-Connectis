package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public Provincia buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return provinciaRepository.findOne(id);
    }
    
    @Override
    public Provincia buscarPorNombre(String nombre) {
      return  provinciaRepository.findByNombre(nombre);
    }
    
    @Override
    public List<Provincia> buscarListaPorNombre(String nombre) {
        return provinciaRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Provincia> buscarListaDeProvinciasPorPais(String pais) {
        return provinciaRepository.findByPaisNombre(pais);
        
    }

    @Override
    public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
       provinciaRepository.delete(id);
       return;
    }

    @Override
    public Provincia insertarProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }
    
    
    

}
