package ru.dimas.scoreboard.repository;

public class MatchResultsDatabase {

    public static String createDatabase(){
        String sql = String.format("create table matchResults( " +
                "id serial primary key, " +
                "player1 int references players (id) "+
                "player2 int references players (id) "+
                "winner int references players (id);");

        return sql;
    }
    public static String selectAllResults(){
        String sql = String.format("select t1.name, t2.name, t3.name from matchResults " +
                                   "join players on matchResults.player1=players.id as t1 " +
                                   "join players on matchResults.player1=players.id as t2 " +
                                   "join players on matchResults.player1=players.id as t3;");
        return sql;
    }

    public static String selectLimitResults(int limit){
        String sql = String.format("select t1.name, t2.name, t3.name from matchResults " +
                "join players on matchResults.player1=players.id as t1 " +
                "join players on matchResults.player1=players.id as t2 " +
                "join players on matchResults.player1=players.id as t3 " +
                "limit 5;");
        return sql;
    }




}
