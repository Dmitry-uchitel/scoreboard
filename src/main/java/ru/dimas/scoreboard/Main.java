package ru.dimas.scoreboard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.dimas.scoreboard.hibernate.HibernateMatchResult;
import ru.dimas.scoreboard.hibernate.HibernatePlayers;
import ru.dimas.scoreboard.hibernate.HibernateUtil;
import ru.dimas.scoreboard.model.MatchResult;
import ru.dimas.scoreboard.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Запись данных

        HibernatePlayers.saveUser("John Doe");
        HibernatePlayers.saveUser("John");
        HibernatePlayers.saveUser("Johnoe");
        HibernatePlayers.saveUser("dimas");
        HibernatePlayers.saveUser("max");

        for (Player pl:HibernatePlayers.getUserList()){
            System.out.println(pl);
        }
        List<Player> playerList = new ArrayList<>(HibernatePlayers.getUserList());
//        System.out.println(HibernatePlayers.getUserByName("John Doe"));
        HibernateMatchResult.saveMatchResult(playerList.get(0), playerList.get(2), playerList.get(2) );
        HibernateMatchResult.saveMatchResult(playerList.get(0), playerList.get(1), playerList.get(0) );
        HibernateMatchResult.saveMatchResult(playerList.get(1), playerList.get(2), playerList.get(1) );

        for (MatchResult matchResult:HibernateMatchResult.getMatchResultList()){
            System.out.println(matchResult);
        }
        // Завершение работы с Hibernate
        HibernateUtil.shutdown();
    }



}