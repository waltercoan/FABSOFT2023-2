package br.edu.univille.projfab2023_2.service;

import java.util.List;

import br.edu.univille.projfab2023_2.entity.Carro;

public interface CarroService {
    List<Carro> getAll();
    
    void save(Carro carro);

    void delete(Carro carro);
}
