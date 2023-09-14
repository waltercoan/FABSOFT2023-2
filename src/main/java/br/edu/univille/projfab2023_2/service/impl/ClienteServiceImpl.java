package br.edu.univille.projfab2023_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.univille.projfab2023_2.entity.Cliente;
import br.edu.univille.projfab2023_2.repository.ClienteRepository;
import br.edu.univille.projfab2023_2.service.ClienteService;

public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;
    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }
    
}
