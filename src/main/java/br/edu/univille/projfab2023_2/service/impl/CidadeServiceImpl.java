package br.edu.univille.projfab2023_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.projfab2023_2.entity.Cidade;
import br.edu.univille.projfab2023_2.repository.CidadeRepository;
import br.edu.univille.projfab2023_2.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{
    @Autowired
    private CidadeRepository repository;
    @Override
    public List<Cidade> getAll() {
        return repository.findAll();
    }
    
}
