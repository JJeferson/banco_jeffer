package com.banco_jeffer.domain.dto;

import com.banco_jeffer.domain.enums.StatusCliente;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClienteDto {
    private String nome;
    private String  cpf;
    private StatusCliente statusCliente;
}
