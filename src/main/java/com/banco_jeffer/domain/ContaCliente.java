package com.banco_jeffer.domain;

import com.banco_jeffer.domain.enums.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "conta_cliente")
public class ContaCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long conta_cliente_id;
    private TipoConta tipoConta;
    private float saldo;
    @ManyToOne
    @JoinColumn(name="clienteid", nullable=false)
    @JsonIgnore
    private Cliente cliente;


}
