package br.edu.univille.projfab2023_2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.edu.univille.projfab2023_2.entity.Cliente;
import br.edu.univille.projfab2023_2.repository.ClienteRepository;
import br.edu.univille.projfab2023_2.service.CidadeService;
import br.edu.univille.projfab2023_2.service.ClienteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ModelAndView index(){

        var listaClientes = service.getAll();
        
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }
    @GetMapping("/paginacao")
    public ModelAndView indexPaging(@RequestParam(defaultValue = "1") int page, 
        @RequestParam(defaultValue = "3") int size){

        Pageable paging = PageRequest.of(page - 1, size);
        var lastPage = service.findAll(paging);
        var listaClientes = lastPage.getContent(); 

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaClientes",listaClientes);
        dados.put("currentPage", lastPage.getNumber() + 1);
        dados.put("totalItems", lastPage.getTotalElements());
        dados.put("totalPages", lastPage.getTotalPages());
        dados.put("pageSize", size);
        
        return new ModelAndView("cliente/indexpage",dados);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        HashMap<String,Object> dados = new HashMap<>();
        var novoCliente = new Cliente();
        var listaCidades = cidadeService.getAll();

        dados.put("cliente",novoCliente);
        dados.put("listaCidades",listaCidades);

        return new ModelAndView("cliente/form", dados);
    }
    @PostMapping
    public ModelAndView save(@Valid Cliente cliente, 
                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> dados = new HashMap<>();
            var listaCidades = cidadeService.getAll();
            dados.put("cliente",cliente);
            dados.put("listaCidades",listaCidades);
            return new ModelAndView("cliente/form", dados);
        }
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");

    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Cliente cliente){

        HashMap<String,Object> dados = new HashMap<>();
        var listaCidades = cidadeService.getAll();
        dados.put("cliente",cliente);
        dados.put("listaCidades",listaCidades);
        

        return new ModelAndView("cliente/form",dados);
    }


    @GetMapping("/remover/{id}")
    public ModelAndView remover(
            @PathVariable("id") Cliente cliente){
        service.delete(cliente);
        return new ModelAndView("redirect:/clientes");
    }

}
