package com.gdm.hermanas.util;

import com.gdm.hermanas.model.Cliente;

import com.gdm.hermanas.model.Endereco;
import com.gdm.hermanas.model.Estoque;
import com.gdm.hermanas.model.Item;
import com.gdm.hermanas.model.Produto;
import com.gdm.hermanas.model.Venda;

import java.util.logging.Level;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:~/hermanas/data");
        configuration.setProperty("hibernate.connection.username", "hermanas");
        configuration.setProperty("hibernate.connection.password", "hermanas");
        configuration.setProperty("hibernate.connection.pool_size", "10");

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().applySettings(configuration.getProperties())
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .addPackage("com.gdm.hermanas.model")
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Endereco.class)
                    .addAnnotatedClass(Produto.class)
                    .addAnnotatedClass(Estoque.class)
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Venda.class)
                    .buildMetadata()
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getHibernateSessionFactory() {
        return sessionFactory;
    }
}
