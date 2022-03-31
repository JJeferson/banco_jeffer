package com.banco_jeffer.application.service;

import com.banco_jeffer.application.in.ClienteUseCase;
import com.banco_jeffer.application.out.ClientePortOut;
import com.banco_jeffer.config.controller_advice.exceptions.InternalServerError;
import com.banco_jeffer.domain.Cliente;
import com.banco_jeffer.domain.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class ClienteService implements ClienteUseCase {
    @Autowired
    ClientePortOut clientePortOut;

    @Override
    public ClienteDto SaveCliente(Cliente cliente) {
        try {
            validaCliente(cliente);
            ClienteDto dto = converteDTO(clientePortOut.SaveCliente(cliente));
            if(dto==null){
                throw new InternalServerError("Erro ao Salvar");
            }
            return dto;

        }catch (JpaSystemException e){
            throw new InternalServerError("Erro ao Salvar"+e.getMessage());
        }

    }

    @Override
    public ClienteDto AlteraCliente(Cliente cliente) {
        return converteDTO(clientePortOut.SaveCliente(cliente));
    }

    @Override
    public ClienteDto FindById(long id) {
        return converteDTO(clientePortOut.FindById(id));
    }

    @Override
    public ClienteDto FincByCpf(long cpf) {
        return converteDTO(clientePortOut.FindByCpf(cpf));
    }

    private void validaCliente(Cliente c){
        Cliente encontraPeloCPF = clientePortOut.FindByCpf(c.getCpf());
        if(encontraPeloCPF != null){
            throw new InternalServerError("CPF já cadastrado, cliente já existe");
        }

    }


    private ClienteDto converteDTO(Cliente c){
        if(c==null){
            return null;
        }
        ClienteDto dto = new ClienteDto();
        dto.setNome(c.getNome());
        dto.setCpf(c.getCpf());
        return  dto;
    }


}
