package com.banco_jeffer.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.NonNull;

import javax.persistence.*;

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
    @NonNull
    private String  cpf;

}
