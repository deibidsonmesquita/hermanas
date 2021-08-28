
package com.gdm.hermanas.repositorio;

import com.gdm.hermanas.model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class UsuarioRepository extends GenericDao<Usuario>{
    
    public boolean isAdm(){
        return false;
    }
    
     public boolean login(String nome, String senha) {
        try (Session s = factory.openSession()) {
            s.beginTransaction();
            Query<Usuario> query = s.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha");
            query.setParameter("nome",nome);
            query.setParameter("senha",senha);
            boolean user =  query.setMaxResults(1).uniqueResultOptional().isPresent();
            s.getTransaction().commit();
            return user;
        }
    }
}
