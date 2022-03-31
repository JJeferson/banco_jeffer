package com.banco_jeffer.domain;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cliente",uniqueConstraints={@UniqueConstraint(columnNames = {"cpf"})})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clienteid;
    @NotNull("Nome precisa ser preenchido")
    private String nome;
    @NotNull("CPF precisa ser preenchido")
    private long   cpf;
}
