package br.edu.univille.projfab2023_2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.univille.projfab2023_2.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();
    
    Page<Cliente> findAll(Pageable pageable);

    void save(Cliente cliente);

    void delete(Cliente cliente);

    String consultaCEP(String CEP);
}
