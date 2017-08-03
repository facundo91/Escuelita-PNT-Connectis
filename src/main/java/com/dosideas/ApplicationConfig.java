package com.dosideas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * En esta clase vemos las siguientes anotaciones:
 *
 * @Configuration: Indica que la clase es una clase de configuración de Spring
 *
 * @EnableAutoConfiguration: Habilita la autoconfiguración de Spring Boot.
 *
 * @ComponentScan: Esta anotación le indica a Spring desde que paquete empezar a
 * escanear. Si no se le indica ningún paquete, (como en este caso), toma como
 * paquete base el de esta clase
 *
 * Nota: Estas 3 anotaciones se pueden reemplazar por @SpringBootApplication.
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationConfig {

}