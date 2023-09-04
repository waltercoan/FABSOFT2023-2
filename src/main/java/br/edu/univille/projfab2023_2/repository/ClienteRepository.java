package br.edu.univille.projfab2023_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.univille.projfab2023_2.entity.Cliente;

@Repository
public interface ClienteRepository 
        extends JpaRepository<Cliente,Long> {
    
}
