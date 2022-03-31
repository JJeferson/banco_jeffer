package com.banco_jeffer.framework.adapter.in;

import com.banco_jeffer.application.in.ClienteUseCase;
import com.banco_jeffer.domain.Cliente;
import com.banco_jeffer.domain.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteAdapterIn   {
    @Autowired
    ClienteUseCase clienteUseCase;

    @Transactional
    @CacheEvict(value = "/novo_cliente", allEntries = true)
    @PostMapping("/novo_cliente")
    public ResponseEntity<ClienteDto> novoCliente(@RequestBody @Validated Cliente cliente)
    {
        return ResponseEntity.ok(clienteUseCase.SaveCliente(cliente));
    }
}
