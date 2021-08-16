/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdm.hermanas.model;

import lombok.Data;

@Data
public class Estoque {
    private Integer id;
    private int inicial;
    private int atual;
    private int minimo;
}
