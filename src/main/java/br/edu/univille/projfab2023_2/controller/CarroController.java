package br.edu.univille.projfab2023_2.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.projfab2023_2.entity.Carro;
import br.edu.univille.projfab2023_2.entity.Manutencao;
import br.edu.univille.projfab2023_2.service.CarroService;


@Controller
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;
    
    @GetMapping
    public ModelAndView index(){
        var listaCarros = carroService.getAll();
        return new ModelAndView("carro/index",
                    "listaCarros",listaCarros);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        var carro = new Carro();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("carro",carro);
        dados.put("novoItem", new Manutencao());
        return new ModelAndView("carro/form", 
                                dados);
    }
    @PostMapping(params = "save")
    public ModelAndView save(Carro carro){

        carroService.save(carro);
        return new ModelAndView("redirect:/carro");
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Carro carro, 
                Manutencao novoItem){
        carro.getListaHistoricoManutencao().add(novoItem);

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("carro", carro);
        dados.put("novoItem", new Manutencao());
        return new ModelAndView("carro/form",dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(Carro carro, 
            @RequestParam("removeitem") int index){
        carro.getListaHistoricoManutencao().remove(index);

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("carro", carro);
        dados.put("novoItem", new Manutencao());
        return new ModelAndView("carro/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") 
                            Carro carro){
        HashMap<String,Object> dados = new HashMap<>();

        dados.put("carro",carro);
        dados.put("novoItem", new Manutencao());
        return new ModelAndView("carro/form",dados);
    }
    @GetMapping("/remover/{id}")
    public ModelAndView remover (@PathVariable("id") Carro carro){
        
        carroService.delete(carro);
        return new ModelAndView("redirect:/carro");
    }
}