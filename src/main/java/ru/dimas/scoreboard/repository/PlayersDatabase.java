package ru.dimas.scoreboard.repository;

public class PlayersDatabase {
    private static final String URL = "jdbc:h2:~/scoreboard"; // Путь к базе данных
    private static final String USER = "sa"; // Имя пользователя
    private static final String PASSWORD = ""; // Пароль (по умолчанию пустой)

    public static String createDatabase(){
        String sql = String.format("create table players( " +
                                    "id serial primary key, " +
                                    "name varchar(30) unique;");
        return sql;
    }

    public static String selectPlayerById(Integer id){
        String sql = String.format("select * from players where id = %d;",id);
        return sql;
    }

    public static String selectNamePlayerById(Integer id){
        String sql = String.format("select name from players where id = %d;",id);
        return sql;
    }

    public static String selectIdPlayerByName(String name){
        String sql = String.format("select id from players where name = %s;",name);
        return sql;
    }



}
