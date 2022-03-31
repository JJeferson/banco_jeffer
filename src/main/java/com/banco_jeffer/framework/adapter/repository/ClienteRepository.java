package com.banco_jeffer.framework.adapter.repository;


import com.banco_jeffer.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findById (long id);
    Cliente findByCpf(String cpf);
}
