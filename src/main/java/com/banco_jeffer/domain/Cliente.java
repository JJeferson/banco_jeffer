package com.banco_jeffer.domain;

import com.banco_jeffer.domain.enums.StatusCliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cliente",uniqueConstraints={@UniqueConstraint(columnNames = {"cpf"})})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clienteid;
    @NonNull
    private String nome;
    @NotNull(message = "CPF precisa ser informado")
    private String  cpf;
    private StatusCliente statusCliente;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.REMOVE)
    private List<ContaCliente> contasCliente;
}
