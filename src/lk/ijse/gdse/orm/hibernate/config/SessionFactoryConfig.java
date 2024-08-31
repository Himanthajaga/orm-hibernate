package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {
    private static SessionFactoryConfig FactoryConfig;

    private SessionFactoryConfig() {
    }

    public static SessionFactoryConfig getInstance() {
        return (null == FactoryConfig) ? FactoryConfig = new SessionFactoryConfig() : FactoryConfig;
    }

    public Session getSession() {
        //first step service registry
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //second step metadata object
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build();
        //third step session factory
       return metadata.buildSessionFactory().openSession();

    }
}