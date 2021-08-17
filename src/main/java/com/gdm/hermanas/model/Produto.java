
package com.gdm.hermanas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Produto implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private BigDecimal valorVenda;
    private BigDecimal valorCusto;
    private BigDecimal valorPromo;
    private double ajuste;
    private String codbar;
    private String und;
    private String cor;
    private String obs;
    private String tamanho;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Estoque estoque;
}
