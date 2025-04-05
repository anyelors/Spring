package com.informaticonfig.spring.app1.springboot_aplication.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.informaticonfig.spring.app1.springboot_aplication.models.Empleados;


@Controller
public class EjemploController {

    /*@GetMapping("/detalles_info")
    public String info(Map<String, Object> modelo){

        modelo.put("Titulo", "Pagina Spring Boot");
        modelo.put("Mensaje", "Servidor en linea!");
        modelo.put("Ip", "192.192.192.192");
        return "detalles_info";
    }*/

    @GetMapping("/detalles_info")
    public String info(Model model){

        Empleados empleado1 = new Empleados("Juan", "Perez", "Calle 123", "Gerente", 30, 123456, 1);

        model.addAttribute("Empleado", empleado1);
        return "detalles_info";
    }
}
