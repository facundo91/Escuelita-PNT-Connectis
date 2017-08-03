package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Pais;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Esta clase representa un test de componente. Los tests de componentes se
 * encargan de testear una clase en particular, y todas las dependencias que la
 * misma tiene.
 *
 * Este test comprueba el funcionamiento de la clase PaisRepository. Esta clase
 * utiliza Spring Data para acceder a la base de datos. Es necesario tener
 * entonces la base de datos iniciada, con el modelo de datos del workshop
 * cargado (ver archivo "Instrucciones para crear la BD").
 *
 * Para iniciar la base de datos: Ir al menu Window > Services > Databases >
 * Java DB > Click derecho > Start server
 *
 * Para ejecutar este test en NetBeans: click derecho > "Test File" (CTRL + F6)
 *
 * Podemos ver que esta clase tiene las siguientes anotaciones:
 *
 * @RunWith(SpringRunner.class): Le indica a JUnit que utilize el Runner de
 * Spring al momento de correr los test (necesario para levantar el contexto de
 * Spring).
 *
 * @SpringBootTest: Si utilizamos una aplicación con Spring Boot, nos da
 * diversas features de Spring Boot (ver Javadoc). Si en la clase
 * ApplicationConfig utilizamos la anotacion @SpringBootApplication, no hace
 * falta pasarle la clase como parámetro
 *
 * @Transactional: Indica que cada uno de los métodos de esta clase es
 * transaccional.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
@Transactional
public class PaisServiceComponenteTest {

    /**
     * La instancia bajo test. La anotación @Autowired hará que Spring la
     * inyecte automáticamente
     */
    @Autowired
    private PaisService paisService;

    /**
     * Test de buscarPorId method con un id existente. El metodo debe encontrar
     * un Pais con el id buscado.
     */
    @Test
    public void buscarPorId_ConIdExistente_retornaProvinciaConEseId() {
        Long id = 1L;

        Pais pais = paisService.buscarPorId(id);

        assertNotNull(pais);
        assertEquals(id, pais.getId());
        assertEquals("Argentina", pais.getNombre());
    }

    /**
     * Test de buscarPorId method con un id inexistente. El metodo debe devolver
     * null al buscar un id que no existe.
     */
    @Test
    public void buscarPorId_ConIdInexistente_retornaNull() {
        Long id = 21L;

        Pais pais = paisService.buscarPorId(id);

        assertNull(pais);
    }

    /**
     * Test de buscarPorId method con un id null. El metodo debe tirar una
     * IllegalArgumentException al intengar invocar al metodo con un null.
     */
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorId_ConIdNull_lanzaExcepcion() {
        paisService.buscarPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }
}
