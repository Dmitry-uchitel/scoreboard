package ru.dimas.scoreboard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dimas.scoreboard.hibernate.HibernateMatchResult;
import ru.dimas.scoreboard.hibernate.HibernatePlayers;
import ru.dimas.scoreboard.hibernate.HibernateUtil;
import ru.dimas.scoreboard.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Запись данных

        HibernatePlayers.savePlayer("John Doe");
        HibernatePlayers.savePlayer("John");
        HibernatePlayers.savePlayer("Johnoe");
        HibernatePlayers.savePlayer("dimas");
        HibernatePlayers.savePlayer("max");

        Matches.addNewMatch(new MatchScore("John Doe", "John"));
        Player playerOne=HibernatePlayers.getPlayerByName("John Doe");
        Player playerTwo=HibernatePlayers.getPlayerByName("John");
        HibernateMatchResult.saveSelectedMatchResult(null);
        Matches.addNewMatch(new MatchScore("max", "John"));
        playerOne=HibernatePlayers.getPlayerByName("max");
        playerTwo=HibernatePlayers.getPlayerByName("John");
        HibernateMatchResult.saveSelectedMatchResult("max");
        Matches.addNewMatch(new MatchScore("dimas", "max"));
        playerOne=HibernatePlayers.getPlayerByName("dimas");
        playerTwo=HibernatePlayers.getPlayerByName("max");
        HibernateMatchResult.saveSelectedMatchResult("dimas");


        for (MatchResult matchResult:HibernateMatchResult.getMatchResultList()){
            String playerOneName = matchResult.getPlayerOne() != null ? matchResult.getPlayerOne().getName() : "Unknown";
            String playerTwoName = matchResult.getPlayerTwo() != null ? matchResult.getPlayerTwo().getName() : "Unknown";
            String winnerName = matchResult.getPlayerWin() != null ? matchResult.getPlayerWin().getName() : "No Winner";
            System.out.println(playerOneName+ "   "+ playerTwoName+" "+winnerName);
        }

//        List<Player> playerList = new ArrayList<>(HibernatePlayers.getUserList());
////        System.out.println(HibernatePlayers.getUserByName("John Doe"));
//        HibernateMatchResult.saveMatchResult(playerList.get(0), playerList.get(2), playerList.get(2) );
//        HibernateMatchResult.saveMatchResult(playerList.get(0), playerList.get(1), playerList.get(0) );
//        HibernateMatchResult.saveMatchResult(playerList.get(1), playerList.get(2), playerList.get(1) );
//
//        for (MatchResult matchResult:HibernateMatchResult.getMatchResultList()){
//            System.out.println(matchResult);
//        }
        // Завершение работы с Hibernate
        HibernateUtil.shutdown();




    }



}