package br.edu.univille.projfab2023_2.service;

import java.util.List;
import br.edu.univille.projfab2023_2.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();

    void save(Cliente cliente);

    void delete(Cliente cliente);
}
