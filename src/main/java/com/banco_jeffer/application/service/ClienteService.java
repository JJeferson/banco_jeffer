package com.banco_jeffer.application.service;

import com.banco_jeffer.application.in.ClienteUseCase;
import com.banco_jeffer.application.out.ClientePortOut;
import com.banco_jeffer.config.controller_advice.exceptions.InternalServerError;
import com.banco_jeffer.config.controller_advice.exceptions.NotFoundException;
import com.banco_jeffer.domain.Cliente;
import com.banco_jeffer.domain.ContaCliente;
import com.banco_jeffer.domain.dto.ClienteDto;
import com.banco_jeffer.domain.enums.StatusCliente;
import com.banco_jeffer.domain.enums.TipoConta;
import com.banco_jeffer.framework.adapter.repository.ContaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements ClienteUseCase {
    @Autowired
    ClientePortOut clientePortOut;
    @Autowired
    ContaClienteRepository contaClienteRepository;

    @Override
    public ClienteDto SaveCliente(Cliente cliente) {
        try {
            validaCliente(cliente);
            cliente.setStatusCliente(StatusCliente.A);


            Cliente novoCliente = clientePortOut.SaveCliente(cliente);

            ContaCliente novaConta = new ContaCliente();
            novaConta.setTipoConta(TipoConta.C);
            novaConta.setSaldo(0);
            novaConta.setCliente(novoCliente);

            contaClienteRepository.save(novaConta);

            ClienteDto dto = converteDTO(novoCliente);
            if(dto==null){
                throw new InternalServerError("Erro ao Salvar");
            }
            List<ContaCliente> lista = new ArrayList();
            lista.add(novaConta);
            dto.setContasCliente(lista);
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
    public ClienteDto FincByCpf(String cpf) {
        validaCPF(cpf);
        ClienteDto dto = converteDTO(clientePortOut.FindByCpf(cpf));
        if(dto==null){
            throw  new NotFoundException("N??o encontrado cliente");
        }
        return dto;
    }

    private void validaCliente(Cliente c){

        validaCPF(c.getCpf());

        Cliente encontraPeloCPF = clientePortOut.FindByCpf(c.getCpf());
        if(encontraPeloCPF != null){
            throw new InternalServerError("CPF j?? cadastrado, cliente j?? existe");
        }


    }

    public void validaCPF(String cpf){
        boolean somenteNumeros = cpf.matches("[0-9]+");
        if(somenteNumeros==false){
            throw new InternalServerError("CPF somente numeros devem ser informados");
        }
        boolean somente11Caracteres = cpf.matches("\\d{11}");
        if(somente11Caracteres==false){
            throw new InternalServerError("CPF s??o 11 caracteres");
        }
        if (cpf==null ||cpf==""){
            throw new InternalServerError("CPF precisa ser informado");
        }
    }

    private ClienteDto converteDTO(Cliente c){
        if(c==null){
            return null;
        }
        ClienteDto dto = new ClienteDto();
        dto.setNome(c.getNome());
        dto.setCpf(c.getCpf());
        dto.setStatusCliente(c.getStatusCliente().getDescricao());

        dto.setContasCliente(c.getContasCliente());
        return  dto;
    }


}
