package com.informaticonfig.spring.app1.springboot_aplication.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informaticonfig.spring.app1.springboot_aplication.models.Empleados;


@RestController
@RequestMapping("/api")

public class EjemploRestController {

    @GetMapping(path = "/detalles_info2")
    public Map<String, Object> detalles_info2 (){

        Empleados empleado1 = new Empleados("Juan", "Perez", "Calle 123", "Gerente", 30, 123456, 1);
        Empleados empleado2 = new Empleados("Maria", "Lopez", "Calle 456", "Contador", 25, 654321, 2);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Emp1", empleado1);
        respuesta.put("Emp2", empleado2);
        return respuesta;
    }
}
