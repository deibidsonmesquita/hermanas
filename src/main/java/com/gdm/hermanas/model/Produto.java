
package com.gdm.hermanas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Estoque estoque;
}
