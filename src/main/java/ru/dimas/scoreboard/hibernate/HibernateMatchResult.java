package ru.dimas.scoreboard.hibernate;

import org.hibernate.Session;
import ru.dimas.scoreboard.model.MatchResult;
import ru.dimas.scoreboard.model.Player;

import java.util.List;

public class HibernateMatchResult {

    public static void saveMatchResult(Player playerOne, Player playerTwo, Player playerWin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        MatchResult matchResult = new MatchResult(playerOne,playerTwo,playerWin);
        session.persist(matchResult);

        session.getTransaction().commit();
        session.close();
    }

    public static MatchResult getMatchResultById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        MatchResult matchResult = session.get(MatchResult.class, id);
        session.close();
        return matchResult;
    }

    public static List<MatchResult> getMatchResultList() {
        List matchResultList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        matchResultList = session.createQuery("FROM matchResults").getResultList();
        session.close();
        return matchResultList;
    }
}
