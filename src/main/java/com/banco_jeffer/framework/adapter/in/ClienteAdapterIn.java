package com.banco_jeffer.framework.adapter.in;

import com.banco_jeffer.application.in.ClienteUseCase;
import com.banco_jeffer.domain.Cliente;
import com.banco_jeffer.domain.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteAdapterIn   {
    @Autowired
    ClienteUseCase clienteUseCase;

    @Transactional
    @CacheEvict(value = "/novo_cliente", allEntries = true)
    @PostMapping("/novo_cliente")
    public ResponseEntity<ClienteDto> novoCliente(@RequestBody @Valid Cliente cliente)
    {
        return ResponseEntity.ok(clienteUseCase.SaveCliente(cliente));
    }

    @Transactional
    @CacheEvict(value = "/consulta_status_cliente", allEntries = true)
    @GetMapping("/consulta_status_cliente")
    public ResponseEntity<ClienteDto> consulta_status_cliente(@RequestParam(value = "cpf",
                                                              required=false,
                                                              defaultValue = "0") String cpf)
    {
        return ResponseEntity.ok(clienteUseCase.FincByCpf(cpf));
    }
}
