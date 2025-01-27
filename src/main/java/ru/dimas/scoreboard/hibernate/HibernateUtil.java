package ru.dimas.scoreboard.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.dimas.scoreboard.model.MatchResult;
import ru.dimas.scoreboard.model.Player;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Player.class).addAnnotatedClass(MatchResult.class);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}