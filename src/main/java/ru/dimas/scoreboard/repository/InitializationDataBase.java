package ru.dimas.scoreboard.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.dimas.scoreboard.model.Player;

public class InitializationDataBase {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    static {
        // Инициализация базы данных
        initializeDatabase();
    }

    private static void initializeDatabase() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(); // Обработка исключений
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
