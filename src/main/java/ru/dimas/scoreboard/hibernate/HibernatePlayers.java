package ru.dimas.scoreboard.hibernate;

import org.hibernate.Session;
import ru.dimas.scoreboard.model.Player;

import java.util.List;

public class HibernatePlayers {

    public static void savePlayer(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List playerList = session.createQuery("FROM Player t WHERE t.name=:name")
                .setParameter("name", name)
                .getResultList();
        if (playerList.isEmpty()){

            session.persist(new Player(name));
        }
        session.getTransaction().commit();
        session.close();
    }

    public static Player getPlayerById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Player player = session.get(Player.class, id);
        session.close();
        return player;
    }

    public static Player getPlayerByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Player player = (Player) session.createQuery("FROM Player t WHERE t.name=:name").
                setParameter("name", name).
                uniqueResult();
        session.close();
        return player;
    }

    public static List<Player> getPlayerList() {
        List playerList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        playerList = session.createQuery("FROM Player").getResultList();
        session.close();
        return playerList;
    }


}
