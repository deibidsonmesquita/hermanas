package com.gdm.hermanas.model;

import com.gdm.hermanas.telas.FormaPgto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Venda implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private BigDecimal total;
    private LocalDate dataVenda;
    private String repsonsavel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "venda")
    private List<Item> itens = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    private FormaPgto pgto;

}
