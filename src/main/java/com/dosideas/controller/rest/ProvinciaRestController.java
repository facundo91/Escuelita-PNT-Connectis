/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.controller.rest;

import com.dosideas.domain.Provincia;
import com.dosideas.exception.ProvinciaNoEncontradaException;
import com.dosideas.service.PaisService;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRestController {

    @Autowired
    private ProvinciaService provinciaService;
    
    @Autowired
    private PaisService paisService;

    @GetMapping("/{id}")
    public Provincia buscarPorId(@PathVariable Long id) throws ProvinciaNoEncontradaException {
        Provincia provincia = provinciaService.buscarPorId(id);
        if (provincia == null) {
            throw new ProvinciaNoEncontradaException("Provincia no encontrada");
        }
        return provincia;
    }
    
    @DeleteMapping("/{id}")
    public Object eliminarPorId(@PathVariable Long id) throws ProvinciaNoEncontradaException {
        provinciaService.eliminarPorId(id);
        return null;
    }
    
    @PostMapping("/")
    public Provincia crarProvincia(@RequestBody Provincia provincia) {
        return provinciaService.insertarProvincia(provincia);
    }
    
}