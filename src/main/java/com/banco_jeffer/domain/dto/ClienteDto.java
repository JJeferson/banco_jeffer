package com.banco_jeffer.domain.dto;

import com.banco_jeffer.domain.ContaCliente;
import com.banco_jeffer.domain.enums.StatusCliente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteDto {
    private String nome;
    private String  cpf;
    private String statusCliente;
    private List<ContaCliente> contasCliente;
}
