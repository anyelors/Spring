package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDaoImp;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDaoImp usuarioDaoImp;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        Usuario usarioLogueado = usuarioDaoImp.obtenerUsuarioPorCredenciales(usuario);
        if (usarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usarioLogueado.getId()), usarioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }

}
