package provincias;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
@Transactional
public class ProvinciaServiceImplTest {

    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_idDeProvinciaExistente_retornoProvinciaConEseIdYSuNombre() {
        Provincia provincia = provinciaService.buscarPorId(4l);
        assertEquals(4, provincia.getId().longValue());
        assertEquals("Chaco", provincia.getNombre());
    }

    @Test
    public void buscarPorId_idDeProvinciaInexistente_retornoNull() {
        Provincia provincia = provinciaService.buscarPorId(Long.MAX_VALUE);
        assertNull(provincia);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorId_null_lanzoExcepcion() {
        provinciaService.buscarPorId(null);
    }
    
    @Test
    public void buscarPorNombre_nombreDeProvinciaExistente_retornaProvincia() {
        Provincia provincia = provinciaService.buscarPorNombre("Chaco");
        assertEquals(4, provincia.getId().longValue());
    }

    @Test
    public void buscarListaPorNombre_nombreDeProvinciaExistente_retornaListaDeProvincias() {
        List<String> provincias = 
                provinciaService.buscarListaPorNombre("San").stream().map(p -> p.getNombre()).collect(Collectors.toList());
        assertTrue(Arrays.asList("San Luis", "San Juan", "Santa Cruz").containsAll(provincias));
    }
    
    @Test
    public void buscarListaPorNombre_nombreDeProvinciaExistente_retornaListaDeProvincias2() {
        List<Provincia> provincias = provinciaService.buscarListaPorNombre("San");
        assertEquals(3,provincias.size());
    }
    
    @Test
    public void buscarListaDeProvinciasPorPais_nombreDePais_retornaListaDeProvincias() {
        List<Provincia> provincias = provinciaService.buscarListaDeProvinciasPorPais("Argentina");
        assertNotNull(provincias);
        assertEquals(20, provincias.size());
    }
    
    @Test
    public void buscarListaPorNombre_nombreDeProvinciaExistente_retornaListaDeProvincia3() {
       Provincia provinciaSanLuis = provinciaService.buscarPorNombre("San Luis");
       Provincia provinciaSanJuan = provinciaService.buscarPorNombre("San Juan");
       Provincia provinciaSantaCruz = provinciaService.buscarPorNombre("Santa Cruz");
       List<Provincia> provincias = provinciaService.buscarListaPorNombre("San");
       assertEquals(Arrays.asList(provinciaSanJuan, provinciaSanLuis, provinciaSantaCruz), provincias);
    }
    
   
    
}
