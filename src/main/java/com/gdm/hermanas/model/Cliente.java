package com.gdm.hermanas.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone1;
    private String telefone2;
    private String nascimento;
    private String sexo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "enderecoID")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(long l) {
        this.codigo = l;
    }

}
