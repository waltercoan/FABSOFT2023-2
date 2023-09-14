package br.edu.univille.projfab2023_2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.univille.projfab2023_2.entity.Cliente;
import br.edu.univille.projfab2023_2.repository.ClienteRepository;
import br.edu.univille.projfab2023_2.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    
    @GetMapping
    public ModelAndView index(){

        var listaClientes = service.getAll();
        
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }
}
