/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdm.hermanas.repositorio;

import com.gdm.hermanas.model.Venda;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author deibi
 */
public class VendaRepository extends GenericDao<Venda>{
    
    public BigDecimal total(LocalDate data){
        Optional<BigDecimal> total;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query<BigDecimal> querytotal = session.createQuery("SELECT SUM(v.total) FROM Venda v WHERE v.dataVenda = :dt");
            querytotal.setParameter("dt", data);
            total = querytotal.uniqueResultOptional();
            session.getTransaction().commit();
        }
        return total.isPresent() ? total.get() : BigDecimal.ZERO;
    }
    
     public BigDecimal ticketDiario(LocalDate data){
        Session session = factory.openSession();
        session.beginTransaction();
        Query<Long> query = session.createQuery("SELECT COUNT(v.id) FROM Venda v WHERE v.dataVenda = :dt");
        query.setParameter("dt", data);
        
         Optional<Long> ticket = query.uniqueResultOptional();
         Long tm = ticket.isPresent() ? ticket.get() : 0L;
    
         
        session.getTransaction().commit();        
        return tm != 0L ? total(data).divide(new BigDecimal(tm)) : BigDecimal.ZERO;
    }
}
