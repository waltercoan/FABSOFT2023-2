package br.edu.univille.projfab2023_2.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.univille.projfab2023_2.entity.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("cliente/index");
    }
}
