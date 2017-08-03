package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    Provincia findByNombre(String nombre);
    List<Provincia> findByNombreContaining(String nombre);
    
    // SQL:    select * from provincia p, pais pp where pp.nombre = 'argentina' and p.id = pp.id
    // JPQL:  from Provincia p where p.pais.nombre = 'Argentina'
    List<Provincia> findByPaisNombre(String pais);

}
