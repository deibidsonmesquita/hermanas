
package com.gdm.hermanas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Item implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
   
    @OneToOne
    private Produto produto;
    
    private int qtde;
    private BigDecimal subtotal;
    
    @ManyToOne
    private Venda venda;

    public Item(int qtde) {
        this.qtde = qtde;
    }

    public Item() {
    }
    
    
    
}
