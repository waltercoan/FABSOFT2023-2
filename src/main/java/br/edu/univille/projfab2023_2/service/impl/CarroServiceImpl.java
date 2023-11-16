package br.edu.univille.projfab2023_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projfab2023_2.entity.Carro;
import br.edu.univille.projfab2023_2.repository.CarroRepository;
import br.edu.univille.projfab2023_2.service.CarroService;

@Service
public class CarroServiceImpl
    implements CarroService {
    
    @Autowired
    private CarroRepository repository;

    @Override
    public List<Carro> getAll() {
        var listaCarros = repository.findAll();
        return listaCarros;
    }

    @Override
    public void save(Carro carro) {
        repository.save(carro);
    }

    @Override
    public void delete(Carro carro) {
        repository.delete(carro);
    }
    
}
