
package com.gdm.hermanas.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Estoque implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    private int inicial;
    private int atual;
    private int minimo;
}
