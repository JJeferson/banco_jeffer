package com.banco_jeffer.application.out;

import com.banco_jeffer.domain.Cliente;

public interface ClientePortOut {
    Cliente SaveCliente (Cliente cliente);
    Cliente FindById(long id);
    Cliente FindByCpf(String cpf);
}
