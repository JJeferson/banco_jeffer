package com.banco_jeffer.application.in;

import com.banco_jeffer.domain.Cliente;
import com.banco_jeffer.domain.dto.ClienteDto;

public interface ClienteUseCase {
    ClienteDto SaveCliente (Cliente cliente);
    ClienteDto AlteraCliente (Cliente cliente);
    ClienteDto FindById(long id);
    ClienteDto FincByCpf(String cpf);
}
