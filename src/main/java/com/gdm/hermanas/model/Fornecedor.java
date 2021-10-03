
package com.gdm.hermanas.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String fone;
    private String email;
    private String ramo;

}
