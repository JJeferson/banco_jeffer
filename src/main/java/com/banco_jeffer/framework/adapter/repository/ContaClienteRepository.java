package com.banco_jeffer.framework.adapter.repository;

import com.banco_jeffer.domain.ContaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaClienteRepository  extends JpaRepository<ContaCliente, Long>{
}
