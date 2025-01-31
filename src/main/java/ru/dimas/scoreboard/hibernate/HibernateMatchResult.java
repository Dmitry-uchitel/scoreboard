package ru.dimas.scoreboard.hibernate;

import org.hibernate.Session;
import ru.dimas.scoreboard.model.MatchResult;
import ru.dimas.scoreboard.model.MatchScore;
import ru.dimas.scoreboard.model.Matches;
import ru.dimas.scoreboard.model.Player;

import java.util.List;

public class HibernateMatchResult {

    private static void saveMatchResult(Player playerOne, Player playerTwo, Player playerWin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        MatchResult matchResult = new MatchResult(playerOne,playerTwo,playerWin);
        session.persist(matchResult);

        session.getTransaction().commit();
        session.close();
    }

    public static void saveSelectedMatchResult(String nameOne){
        Player playerOne=HibernatePlayers.getPlayerByName(Matches.getMatchScoreMap().get(Matches.getSelectedUUID()).getNameOne());
        Player playerTwo=HibernatePlayers.getPlayerByName(Matches.getMatchScoreMap().get(Matches.getSelectedUUID()).getNameTwo());
        Player playerWin=(!(nameOne==null))?playerOne:playerTwo;
        HibernateMatchResult.saveMatchResult(playerOne, playerTwo, playerWin);
        Matches.deleteCurrentMatch();
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
        matchResultList = session.createQuery("FROM MatchResult").getResultList();
        session.close();
        return matchResultList;
    }

    public static void addGameInRezult(String name1, String name2, String nameWin){
        HibernatePlayers.savePlayer(name1);
        HibernatePlayers.savePlayer(name2);

        Matches.addNewMatch(new MatchScore(name1, name2));
        Player playerOne=HibernatePlayers.getPlayerByName(name1);
        Player playerTwo=HibernatePlayers.getPlayerByName(name2);
        MatchScore matchScore = new MatchScore(name1, name2);
        if (nameWin.equals(name1)){
            HibernateMatchResult.saveSelectedMatchResult(nameWin);
        }
        else {
            HibernateMatchResult.saveSelectedMatchResult(null);
        }
    }

    public static List getFilterMatchResultList(String name){
        List matchResultList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        matchResultList = HibernatePlayers.getPlayerByName(name).getMatchResultListOne();
        matchResultList.addAll(HibernatePlayers.getPlayerByName(name).getMatchResultListTwo());
        session.close();

        return matchResultList;
    }

}
