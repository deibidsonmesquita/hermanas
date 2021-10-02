/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gdm.hermanas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Caixa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private LocalDateTime dataHora;
    private BigDecimal valor;
    
    private String responsavel;

    public Caixa(LocalDateTime dataHora, BigDecimal valor, String responsavel) {
        this.dataHora = dataHora;
        this.valor = valor;
        this.responsavel = responsavel;
    }

    public Caixa() {
    }

    public Caixa(Long id) {
        this.id = id;
    }
    
    

   
    
}
