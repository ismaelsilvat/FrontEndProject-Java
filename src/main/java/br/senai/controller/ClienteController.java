package br.senai.controller;

import br.senai.service.ClienteServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @Autowired
    ClienteServiceImple clienteService;

    @GetMapping("/cliente/list")
    public String findAll(){
        return "cliente/list";
    }
}
