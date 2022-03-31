package com.banco_jeffer.framework.adapter.out;

import com.banco_jeffer.application.out.ClientePortOut;
import com.banco_jeffer.config.controller_advice.exceptions.BadGatewayException;
import com.banco_jeffer.config.controller_advice.exceptions.InternalServerError;
import com.banco_jeffer.domain.Cliente;
import com.banco_jeffer.framework.adapter.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteAdapterOut implements ClientePortOut   {
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public Cliente SaveCliente(Cliente cliente) {
       return  clienteRepository.save(cliente);
    }

    @Override
    public Cliente FindById(long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente FindByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}
