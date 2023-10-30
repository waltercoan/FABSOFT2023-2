package br.edu.univille.projfab2023_2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.univille.projfab2023_2.entity.Cliente;

@Repository
public interface ClienteRepository 
        extends JpaRepository<Cliente,Long> {
    Page<Cliente> findAll(Pageable pageable);
}
